package com.desafio.quality.exception;

import com.desafio.quality.exception.dto.ValidationExceptionDTO;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class PropertyControllerExceptionHandler {
    private final MessageSource messageSource;

    public PropertyControllerExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

//    formata a exception levantada pelas anotações de validação
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public List<ValidationExceptionDTO> handleValidation(MethodArgumentNotValidException exception) {
        List<ValidationExceptionDTO> validationErrorsDTO = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            validationErrorsDTO.add(new ValidationExceptionDTO(e.getField(), message));
        });

        return validationErrorsDTO;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String handleRuntime(RuntimeException exception) {
        return exception.getMessage();
    }
}
