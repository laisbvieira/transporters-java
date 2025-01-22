# Logistics - Sistema de Gestão de Transportadores

Este é um projeto simples de gestão de transportadores utilizando **Spring Boot** e **JPA** com banco de dados **H2**. A aplicação permite realizar operações básicas como criar, listar, atualizar e excluir transportadores.

## Tecnologias Utilizadas

- **Java 17** - A versão do Java utilizada.
- **Spring Boot 3.4.0** - Framework para construir aplicações Java.
- **Spring Data JPA** - Para persistência de dados.
- **H2 Database** - Banco de dados em memória para desenvolvimento.
- **Spring Web** - Para criar APIs RESTful.

## Funcionalidades

A aplicação oferece os seguintes endpoints para interação:

- **GET /transportadores** - Retorna todos os transportadores cadastrados.
- **GET /transportadores/{id}** - Retorna um transportador específico pelo seu ID.
- **POST /transportadores** - Cria um novo transportador.
- **PUT /transportadores/{id}** - Atualiza os dados de um transportador existente.
- **DELETE /transportadores/{id}** - Deleta um transportador pelo seu ID.

## Como Rodar o Projeto

### Pré-requisitos

Certifique-se de ter o **Java 17** e o **Maven** instalados em sua máquina. Se você não tiver o Maven instalado, pode usar o wrapper do Maven (incluso no projeto) para rodar os comandos.

### Rodando Localmente

## 1. Clone o repositório:
   ```bash
   git clone https://github.com/laisbvieira/transporters-java.git
   cd transporters-java
```

## 2. Compile e rode a aplicação com Maven:

```bash
mvn spring-boot:run
```

Ou, se preferir usar o Maven Wrapper:

``` bash
./mvnw spring-boot:run
```

    A aplicação estará rodando em http://localhost:8080.

    Acesse o console H2 para visualizar o banco de dados em http://localhost:8080/h2-console.
        URL: jdbc:h2:file:/home/lais/test/logistics;DB_CLOSE_DELAY=-1;AUTO_SERVER=TRUE
        Username: sa
        Password: (deixe em branco)

## 3. Testando a API

Você pode testar os endpoints da API usando ferramentas como Postman ou cURL.
Exemplos de requisições:

    GET /transportadores:

```bash
curl -X GET http://localhost:8080/transportadores
```

POST /transportadores (Criando um novo transportador):

    curl -X POST http://localhost:8080/transportadores \
     -H "Content-Type: application/json" \
     -d '{"nome": "Transportadora X", "cnpj": "12345678000195", "razaoSocial": "Transportadora X Ltda", "responsavel": "João Silva", "ie": "123456789", "celular": "987654321", "telefoneComercial": "123456789", "situacao": "Ativo"}'

## 4. Banco de Dados (H2)

Este projeto usa o H2 Database, um banco de dados em memória. Contudo, a configuração atual permite que o banco seja persistido no arquivo logistics.mv.db, garantindo que os dados fiquem armazenados entre as execuções da aplicação.
Como Funciona?

    Em Memória: O banco é em memória por padrão, e os dados são apagados ao reiniciar a aplicação.
    Persistência em Arquivo: Durante a execução, os dados são armazenados no arquivo logistics.mv.db, permitindo que a pessoa visualize ou interaja com os dados mesmo após o reinício da aplicação.

Acessando e Interagindo com o Banco:

    Console H2: Acesse o console do banco de dados em:
    http://localhost:8080/h2-console

    Configuração do Console:
        JDBC URL: jdbc:h2:file:/home/username/test/logistics;DB_CLOSE_DELAY=-1;AUTO_SERVER=TRUE
        Username: sa
        Password: (deixe em branco)

    Substitua o caminho /home/username/test/logistics pelo seu diretório local.

    Observação sobre a Persistência: Caso você queira manter os dados entre as execuções da aplicação, certifique-se de que o arquivo logistics.mv.db esteja presente no diretório configurado.

    Importante: O banco de dados H2 em memória é útil para testes rápidos, mas se você precisar manter os dados permanentemente, use a configuração de persistência em arquivo como mencionado.
