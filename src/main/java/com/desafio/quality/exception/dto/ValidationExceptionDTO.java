package com.desafio.quality.exception.dto;

public class ValidationExceptionDTO {
    public String field;
    public String message;

    public ValidationExceptionDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
