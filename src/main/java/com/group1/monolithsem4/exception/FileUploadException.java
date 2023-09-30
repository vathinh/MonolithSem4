package com.group1.monolithsem4.exception;

import java.io.Serial;

public class FileUploadException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public FileUploadException(String msg) {
        super(msg);
    }
}
