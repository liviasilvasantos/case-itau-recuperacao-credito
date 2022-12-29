package com.liviasilvasantos.itau.debt.gateway.exception;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {DebtNotFoundException.class})
    public ResponseEntity<ErrorMessage> handleNotFound(final RuntimeException exception,
                                                       final WebRequest request) {
        val errorMessage = buildErrorMessage(exception, request, HttpStatus.NOT_FOUND, null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, ConstraintViolationException.class})
    public ResponseEntity<ErrorMessage> handleClientException(final RuntimeException exception,
                                                              final WebRequest request) {
        val errorMessage = buildErrorMessage(exception, request, HttpStatus.BAD_REQUEST, null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationExceptions(
            final MethodArgumentNotValidException exception, final WebRequest request) {
        log.error(exception.getMessage(), exception);

        val errors = new ArrayList<String>();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            val fieldName = ((FieldError) error).getField();
            val errorMessage = error.getDefaultMessage();
            errors.add("%s: %s".formatted(fieldName, errorMessage));
        });

        val errorMessage = buildErrorMessage(null, request, HttpStatus.BAD_REQUEST, errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    private static ErrorMessage buildErrorMessage(final RuntimeException exception, final WebRequest request,
                                                  final HttpStatus status, final List<String> validationErrors) {
        val errorMessage = ErrorMessage.builder()
                .message(Optional.ofNullable(exception).map(e -> e.getMessage()).orElse(null))
                .timestamp(LocalDateTime.now())
                .error(status.getReasonPhrase())
                .code(status.value())
                .path(request.getDescription(false))
                .validationErrors(validationErrors)
                .build();
        return errorMessage;
    }

}
