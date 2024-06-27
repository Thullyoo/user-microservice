# Api MicroService de cadastro de Usuário (Java 🚀 com Spring Boot 🍃 )

**Utilizando CloudAMQP para RabbitMQ**

Este projeto utiliza CloudAMQP para gerenciamento de mensagens com RabbitMQ. 

Este é um projeto Java Spring boot, que consiste em uma API para cadastro de usuários, onde após o cadastro é enviado uma message para o RabbitMQ, onde é conectado a outra Api de Email, para o envio do email dizendo sobre o conclusão do cadastro.

## Configuração

1. Clone o repositório para sua máquina local:

    ```bash
    git clone https://github.com/Thullyoo/user-microservice
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd user-microservice
    ```

3. Instale as dependências com o maven

4. Coloque suas variáveis necessárias no application.properties, as seguintes varávies são necessárias:
   - spring.datasource.username
   - spring.datasource.password
   - spring.rabbitmq.addresses

5. Inicie a aplicação

A aplicação estará rodando em `http://localhost:8080`.

### Endpoints

- `Post /user/register`: Cadastro do usuário.

### Formato dos dados

As requisições e respostas são no formato JSON. Exemplo de como se deve passar o JSON no POST:

```json
{
  "nome": "nome",
  "email": "email@email.com",
  "senha": "senha",
  "enderecos": [
    {"rua": "rua",
    "numero": "numero",
    "estado": "estado",
    "cidade": "cidade"
    }
  ]
}
