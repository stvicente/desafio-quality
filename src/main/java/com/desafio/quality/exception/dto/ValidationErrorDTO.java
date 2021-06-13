package com.desafio.quality.exception.dto;

public class ValidationErrorDTO {
    public String field;
    public String message;

    public ValidationErrorDTO() {}

    public ValidationErrorDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
