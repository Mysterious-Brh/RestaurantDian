package com.wzlt.restaurantdian.exception;

import com.wzlt.restaurantdian.common.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Result<?>> handleCustomException(CustomException ex, WebRequest request) {
        return new ResponseEntity<>(Result.error(400, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<?>> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(Result.error(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
