package Ergin.demo.dto;

import java.util.Date;

public record ErrorResponse (
    Date timestamp,
    Integer status,
    String error,
    String path
            ) {}
