package com.group1.monolithsem4.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileService {

    void init();

    void save(MultipartFile file);

    Resource load(String fileName);

    void deleteAll();

    boolean delete(String fileName);

    Stream<Path> loadAll();
}
