package com.liviasilvasantos.itau.customer.gateway.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage implements Serializable {

    private LocalDateTime timestamp;
    private int code;
    private String error;
    private String message;
    private String path;
    private List<String> validationErrors;
}
