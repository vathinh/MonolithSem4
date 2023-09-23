package com.group1.monolithsem4.exception;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class ErrorMessage {
    private int statusCode;
    private Date timeStamp;
    private String message;
    private String description;
}
