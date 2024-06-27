package com.thullyoo.user_microservice.entities.user;

import com.thullyoo.user_microservice.entities.endereco.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UserRequest(@NotNull(message = "Nome não pode ser nulo") @NotBlank(message = "Nome não pode ser vazio")  String nome,
                          @NotNull(message = "Senha não pode ser nula")  @NotBlank(message = "Senha não pode ser vazia")  String senha,
                          @NotNull(message = "Email não pode ser nulo")  @NotBlank(message = "Email não pode ser vazio")  @Email(message = "Email inválido")  String email,
                          @NotEmpty(message = "Endereço não pode ser vazio") List<Endereco> enderecos) {
}
