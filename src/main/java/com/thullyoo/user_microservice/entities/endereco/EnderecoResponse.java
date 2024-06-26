package com.thullyoo.user_microservice.entities.endereco;

import java.util.UUID;

public record EnderecoResponse(String rua, String numero, String cidade, String estado, UUID userId) {
}
