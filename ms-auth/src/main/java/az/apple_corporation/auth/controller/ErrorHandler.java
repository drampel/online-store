package az.apple_corporation.auth.controller;

import az.apple_corporation.auth.model.ErrorDto;
import az.apple_corporation.auth.model.exception.AuthException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static az.apple_corporation.auth.model.constants.ErrorCodes.ACCESS_TOKEN_EXPIRED;
import static az.apple_corporation.auth.model.constants.ErrorCodes.UNEXPECTED_EXCEPTION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AuthException.class)
    public ResponseEntity<Object> handleAuthException(AuthException ex, WebRequest webRequest) {
        return handleExceptionInternal(ex,
                ErrorDto.builder()
                        .code(ex.getCode())
                        .message(ex.getMessage())
                        .build(),
                new HttpHeaders(),
                ex.getCode().equals(ACCESS_TOKEN_EXPIRED) ? HttpStatus.UNAUTHORIZED : HttpStatus.FORBIDDEN,
                webRequest);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest) {
        ex.printStackTrace();
        return handleExceptionInternal(ex,
                ErrorDto.builder()
                        .code(UNEXPECTED_EXCEPTION)
                        .message(ex.getMessage())
                        .build(),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                webRequest);
    }
}