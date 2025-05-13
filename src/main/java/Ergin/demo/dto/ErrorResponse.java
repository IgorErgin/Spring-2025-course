package Ergin.demo.dto;

import java.util.List;

public record ErrorResponse(
        String code,
        String message,
        List<FieldError> fields
) {
    public record FieldError(
            String field,
            String fieldMessage,
            Object rejectedValue
    ) {
    }
}
