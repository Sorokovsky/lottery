package org.sorokovsky.lottery.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.sorokovsky.lottery.contract.ApiError;
import org.sorokovsky.lottery.exception.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;


@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ApiError> handleValidationException(ConstraintViolationException ex) {
        return generateResponse(new ApiError(ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(",")), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler({HttpException.class})
    public ResponseEntity<ApiError> handleHttpException(HttpException ex) {
        var apiError = new ApiError(ex.getMessage(), ex.getStatus().value());
        return generateResponse(apiError);
    }

    private ResponseEntity<ApiError> generateResponse(ApiError error) {
        return ResponseEntity.status(error.status()).body(error);
    }
}
