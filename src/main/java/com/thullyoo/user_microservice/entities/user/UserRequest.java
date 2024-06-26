package com.thullyoo.user_microservice.entities.user;

import com.thullyoo.user_microservice.entities.endereco.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UserRequest(@NotNull @NotBlank String nome,
                          @NotNull @NotBlank String senha,
                          @NotNull @NotBlank @Email String email,
                          List<Endereco> enderecos) {
}
