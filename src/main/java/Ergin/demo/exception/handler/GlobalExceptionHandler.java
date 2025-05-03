package Ergin.demo.exception.handler;

import Ergin.demo.dto.ErrorResponse;
import Ergin.demo.exception.RateLimitException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    @ExceptionHandler(RateLimitException.class)
    public ErrorResponse handleRateLimitException(RateLimitException e, HttpServletRequest req) {
        return new ErrorResponse(
                new Date(),
                429,
                e.getMessage(),
                req.getServletPath()
        );
    }
}
