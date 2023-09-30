package com.group1.monolithsem4.service.impl;

import com.group1.monolithsem4.model.FileEntity;
import com.group1.monolithsem4.repository.FileRepository;
import com.group1.monolithsem4.service.FileService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class FIleServiceImpl implements FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FIleServiceImpl.class);

    private final FileRepository fileRepository;

    @Override
    public FileEntity store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        FileEntity FileDB = new FileEntity(fileName, file.getContentType(), file.getBytes());

        return fileRepository.save(FileDB);
    }

    @Override
    public FileEntity getFile(String id) {
        Optional<FileEntity> fileOptional = fileRepository.findById(id);
        if (fileOptional.isPresent()) {
            return fileOptional.get();
        } else {
            throw new RuntimeException("File with ID " + id + " not found");
        }
    }


    @Override
    public Stream<FileEntity> getAllFiles() {
        return fileRepository.findAll().stream();
    }
}
