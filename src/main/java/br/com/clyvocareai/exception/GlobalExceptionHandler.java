package br.com.clyvocareai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            ResourceNotFoundException.class
    )
    public ResponseEntity<ErrorResponse>
    handleNotFound(
            ResourceNotFoundException ex
    ) {

        ErrorResponse response =
                new ErrorResponse(
                        "Recurso não encontrado",
                        ex.getMessage(),
                        LocalDateTime.now(),
                        HttpStatus.NOT_FOUND.value()
                );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(
            MethodArgumentNotValidException.class
    )
    public ResponseEntity<ValidationErrorResponse>
    handleValidation(
            MethodArgumentNotValidException ex
    ) {

        Map<String, String> errors =
                new HashMap<>();

        for (FieldError error :
                ex.getBindingResult()
                        .getFieldErrors()) {

            errors.put(
                    error.getField(),
                    error.getDefaultMessage()
            );
        }

        ValidationErrorResponse response =
                new ValidationErrorResponse(
                        "Erro de validação",
                        errors,
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value()
                );

        return ResponseEntity
                .badRequest()
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse>
    handleGeneric(
            Exception ex
    ) {

        ErrorResponse response =
                new ErrorResponse(
                        "Erro interno",
                        ex.getMessage(),
                        LocalDateTime.now(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value()
                );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}