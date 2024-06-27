package com.thullyoo.user_microservice.exceptions.responseExeceptions;

import org.springframework.http.HttpStatus;

public record ValidationResponse(HttpStatus status, String message) {
}
