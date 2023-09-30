package com.group1.monolithsem4.dto.file;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FileResponse {
    private String name;
    private String url;
    private String type;
    private long size;}
