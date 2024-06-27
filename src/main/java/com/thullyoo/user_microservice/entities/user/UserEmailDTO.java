package com.thullyoo.user_microservice.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserEmailDTO {
    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;
}
