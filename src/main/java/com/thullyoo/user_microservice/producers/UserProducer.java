package com.thullyoo.user_microservice.producers;

import com.thullyoo.user_microservice.entities.user.UserEmailDTO;
import com.thullyoo.user_microservice.entities.user.UserResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${broker.default.email.name}")
    private String routingKey;

    public void publishMessage(UserResponse userResponse){

        UserEmailDTO emailDTO = new UserEmailDTO(userResponse.userId(),
                userResponse.email(),
                "Cadastro concluído!",
                userResponse.nome() + " Seja bem vindo(a) \nAgora você pode aproveitar nossos serviços!!");

        rabbitTemplate.convertAndSend("", routingKey, emailDTO);

    }

}
