package com.thullyoo.user_microservice.entities.endereco;

import com.thullyoo.user_microservice.entities.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enderecoId;

    private String rua;
    private String numero;
    private String cidade;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
