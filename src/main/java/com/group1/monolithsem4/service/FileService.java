package com.group1.monolithsem4.service;

import com.group1.monolithsem4.model.FileEntity;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileService {

    FileEntity store(MultipartFile file) throws IOException;

    FileEntity getFile(String id);

    Stream<FileEntity> getAllFiles();
}
