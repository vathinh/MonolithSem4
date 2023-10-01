package com.group1.monolithsem4.dto.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FileRequest {
    private String name;
    private String type;
    private byte[] data;
    private String linkedTable;
    private String linkedId;
}
