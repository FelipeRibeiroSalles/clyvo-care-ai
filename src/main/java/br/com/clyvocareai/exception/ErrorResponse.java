package br.com.clyvocareai.exception;

import java.time.LocalDateTime;

public record ErrorResponse(

        String error,
        String message,
        LocalDateTime timestamp,
        Integer status

) {
}