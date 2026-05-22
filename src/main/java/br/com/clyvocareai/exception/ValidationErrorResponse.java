package br.com.clyvocareai.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ValidationErrorResponse(

        String error,
        Map<String, String> fields,
        LocalDateTime timestamp,
        Integer status

) {
}