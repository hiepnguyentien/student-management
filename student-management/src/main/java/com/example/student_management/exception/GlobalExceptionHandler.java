package com.example.student_management.exception;

import com.example.student_management.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception, Locale locale) {
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(messageSource.getMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessageKey(), null, locale));
        log.error(exception.getMessage(), exception);
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException exception, Locale locale) {
        ErrorCode errorCode = exception.getErrorCode();
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(messageSource.getMessage(errorCode.getMessageKey(), null, locale));
        log.error(exception.getMessage(), exception);
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException exception, Locale locale) {
        @SuppressWarnings("null")
        String enumKey = exception.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.INVALID_KEY;
        log.error(exception.getMessage(), exception);
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        } catch (IllegalArgumentException e) {
        }

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(messageSource.getMessage(errorCode.getMessageKey(), null, locale));

        return ResponseEntity.badRequest().body(apiResponse);
    }
}
