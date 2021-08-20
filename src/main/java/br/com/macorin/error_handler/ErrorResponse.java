package br.com.macorin.error_handler;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ErrorResponse {

    private HttpStatus status;
    private String message;
    private List<String> errors;
    private LocalDateTime timestamps = LocalDateTime.now();

    public ErrorResponse(HttpStatus status, String message, Throwable ex) {
        this(status, message, Arrays.asList(ExceptionUtils.getStackTrace(ex)));
    }

    public ErrorResponse(HttpStatus status, String message, String error) {
        this(status, message, Arrays.asList(error));
    }

    public ErrorResponse(HttpStatus status, String message, List<String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public LocalDateTime getTimestamps() {
        return timestamps;
    }
}
