package az.apple_corporation.user.controller;

import az.apple_corporation.user.model.ErrorDto;
import az.apple_corporation.user.model.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static az.apple_corporation.user.model.constants.ErrorCodes.UNEXPECTED_EXCEPTION;
import static az.apple_corporation.user.model.constants.ErrorCodes.USER_NOT_FOUND;
import static az.apple_corporation.user.model.constants.ErrorCodes.USER_UNEXPECTED_ERROR;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest webRequest) {
        return handleExceptionInternal(ex,
                ErrorDto.builder()
                        .timestamp(LocalDateTime.now())
                        .error(USER_NOT_FOUND)
                        .message(ex.getMessage())
                        .build(),
                new HttpHeaders(),
                NOT_FOUND,
                webRequest);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest webRequest) {
        return handleExceptionInternal(ex,
                ErrorDto.builder()
                        .timestamp(LocalDateTime.now())
                        .error(USER_UNEXPECTED_ERROR)
                        .message(ex.getMessage())
                        .build(),
                new HttpHeaders(),
                INTERNAL_SERVER_ERROR,
                webRequest);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers,
                                                               HttpStatus status,
                                                               WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return handleExceptionInternal(ex,
                ErrorDto.builder()
                        .timestamp(LocalDateTime.now())
                        .error(UNEXPECTED_EXCEPTION)
                        .message(errors.toString())
                        .build(),
                headers,
                INTERNAL_SERVER_ERROR,
                request);
    }
}