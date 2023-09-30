package com.group1.monolithsem4.controller;

import com.group1.monolithsem4.dto.file.FileResponse;
import com.group1.monolithsem4.model.FileEntity;
import com.group1.monolithsem4.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

import static com.group1.monolithsem4.controller.EndPoints.FILE_PATH;

@RestController
@RequestMapping(FILE_PATH)
@Slf4j
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("upload")
    public ResponseEntity<FileResponse> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            fileService.save(file);

            message = "Upload the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new FileResponse(message));
        } catch (Exception ex) {
            message = "Could not upload the file: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileResponse(message));
        }
    }

    @GetMapping("files")
    public ResponseEntity<List<FileEntity>> getListFiles() {
        List<FileEntity> fileEntityList = fileService.loadAll().map(path -> {
            String fileName = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();
            return new FileEntity(fileName, url);
        }).toList();

        return ResponseEntity.status(HttpStatus.OK).body(fileEntityList);
    }

    @GetMapping("files/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) {
        Resource file = fileService.load(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @DeleteMapping("files/{fileName:.+}")
    public ResponseEntity<FileResponse> deleteFile(@PathVariable String fileName) {
        String message = "";

        try {
            boolean existed = fileService.delete(fileName);

            if (existed) {
                message = "Delete the file successfully: " + fileName;
                return ResponseEntity.status(HttpStatus.OK).body(new FileResponse(message));
            }

            message = "The file does not exist!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new FileResponse(message));
        } catch (Exception e) {
            message = "Could not delete the file: " + fileName + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new FileResponse(message));
        }
    }

}
