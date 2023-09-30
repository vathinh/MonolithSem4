package com.group1.monolithsem4.service.impl;

import com.group1.monolithsem4.service.FileService;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class FIleServiceImpl implements FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FIleServiceImpl.class);

    private final Path root = Paths.get("uploads");

    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            LOGGER.error("Can not create directory to store files");
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void save(MultipartFile file) {
        try {
            Path filePath = this.root.resolve(Objects.requireNonNull(file.getOriginalFilename()));

            // Attempt to delete the existing file if it exists
            Files.deleteIfExists(filePath);

            // Copy the new file
            Files.copy(file.getInputStream(), filePath);
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                LOGGER.error("File name already existed");
                throw new RuntimeException("A file of that name already existed");
            }
            LOGGER.error("Error: " + e.getMessage());
            throw new RuntimeException("Error: " + e.getMessage());
        }
        System.gc();
    }

    @Override
    public Resource load(String fileName) {
        try {
            Path file = root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());

            if(resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                LOGGER.error("Could not load the file: " + fileName);
                throw new RuntimeException("Could not load the file!");
            }
        } catch (MalformedURLException ex) {
            LOGGER.error("MalformedURL: " + ex.getMessage());
            throw new RuntimeException("Error: " + ex.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public boolean delete(String fileName) {
        try {
            Path file = root.resolve(fileName);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("Delete File Error: " + e.getMessage());
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            LOGGER.error("Could not load all the files");
            throw new RuntimeException("Could not load the files!");
        }
    }
}
