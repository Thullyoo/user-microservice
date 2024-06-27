package com.thullyoo.user_microservice.exceptions;

import com.thullyoo.user_microservice.exceptions.responseExeceptions.ValidationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationResponse>> handleValidationExceptions(MethodArgumentNotValidException exception){
        List<ValidationResponse> validationResponses = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach(e -> {
            validationResponses.add(new ValidationResponse(HttpStatus.UNPROCESSABLE_ENTITY, e.getDefaultMessage()));
        });

        return ResponseEntity.unprocessableEntity().body(validationResponses);
    }

}
