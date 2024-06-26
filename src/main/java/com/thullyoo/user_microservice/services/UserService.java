package com.thullyoo.user_microservice.services;

import com.thullyoo.user_microservice.entities.endereco.Endereco;
import com.thullyoo.user_microservice.entities.endereco.EnderecoResponse;
import com.thullyoo.user_microservice.entities.user.User;
import com.thullyoo.user_microservice.entities.user.UserRequest;
import com.thullyoo.user_microservice.entities.user.UserResponse;
import com.thullyoo.user_microservice.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse registerUser(UserRequest request){


        User user = User.builder()
                .nome(request.nome())
                .email(request.email())
                .senha(request.senha())
                .build();

        List<Endereco> enderecos = new ArrayList<>();
        for (Endereco endereco : request.enderecos()){
            endereco.setUser(user);
        }

        user.setEnderecos(request.enderecos());

        userRepository.save(user);

        UserResponse userResponse = new UserResponse(user.getUserId(), user.getNome(), user.getEmail(), user.getEnderecos().stream().map(endereco -> new EnderecoResponse(endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado(), endereco.getUser().getUserId())).toList());

        return userResponse;
    }
}
