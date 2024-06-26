package com.thullyoo.user_microservice.entities.user;

import com.thullyoo.user_microservice.entities.endereco.Endereco;
import com.thullyoo.user_microservice.entities.endereco.EnderecoResponse;

import java.util.List;
import java.util.UUID;

public record UserResponse(UUID userId, String nome,String email, List<EnderecoResponse> enderecos) {
}
