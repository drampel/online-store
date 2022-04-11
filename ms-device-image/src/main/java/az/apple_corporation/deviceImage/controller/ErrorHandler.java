package az.apple_corporation.deviceImage.controller;

import az.apple_corporation.deviceImage.model.ErrorDto;
import az.apple_corporation.deviceImage.model.exception.DeviceImageNotFoundException;
import az.apple_corporation.deviceImage.model.exception.ImageException;
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

import static az.apple_corporation.deviceImage.model.constants.ErrorCodes.DEVICE_IMAGE_NOT_FOUND;
import static az.apple_corporation.deviceImage.model.constants.ErrorCodes.DEVICE_IMAGE_UNEXPECTED_ERROR;
import static az.apple_corporation.deviceImage.model.constants.ErrorCodes.DEVICE_INPUT_OUTPUT_EXCEPTION;
import static az.apple_corporation.deviceImage.model.constants.ErrorCodes.UNEXPECTED_EXCEPTION;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DeviceImageNotFoundException.class)
    public ResponseEntity<Object> handleDeviceImageNotFoundException(DeviceImageNotFoundException ex,
                                                                     WebRequest webRequest) {
        return handleExceptionInternal(ex,
                ErrorDto.builder()
                        .timestamp(LocalDateTime.now())
                        .error(DEVICE_IMAGE_NOT_FOUND)
                        .message(ex.getMessage())
                        .build(),
                new HttpHeaders(),
                NOT_FOUND,
                webRequest);
    }

    @ExceptionHandler(ImageException.class)
    public ResponseEntity<Object> handleDeviceImageNotFoundException(ImageException ex,
                                                                     WebRequest webRequest) {
        return handleExceptionInternal(ex,
                ErrorDto.builder()
                        .timestamp(LocalDateTime.now())
                        .error(DEVICE_INPUT_OUTPUT_EXCEPTION)
                        .message(ex.getMessage())
                        .build(),
                new HttpHeaders(),
                BAD_REQUEST,
                webRequest);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest webRequest) {
        return handleExceptionInternal(ex,
                ErrorDto.builder()
                        .timestamp(LocalDateTime.now())
                        .error(DEVICE_IMAGE_UNEXPECTED_ERROR)
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
                headers, INTERNAL_SERVER_ERROR, request);
    }
}