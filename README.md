# Sistema de Autenticação com Spring Boot, JWT e Controle de Acesso

Projeto feito para a prova prática da disciplina. O objetivo é criar um sistema simples de autenticação usando Spring Boot, com tokens JWT e controle de acesso por tipo de usuário (`admin` e `user`).

## Tecnologias usadas

- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Banco de dados H2 (em memória)
- Swagger (documentação)
- Lombok (para reduzir código repetitivo)

## Funcionalidades

- Cadastro de usuários com nome, e-mail, senha e role
- Login com geração de token JWT
- Proteção de endpoints com base no tipo de usuário
- Permissões separadas para admin e user
- Banco em memória (não precisa instalar nada)

## Como testar

### 1. Rodar o projeto

```
mvn spring-boot:run
```

### 2. Acessar o Swagger

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### 3. Cadastrar usuário (POST `/auth/register`)

```json
{
  "name": "Kauan",
  "email": "kauan@email.com",
  "password": "123456",
  "role": "admin"
}
```

### 4. Fazer login (POST `/auth/login`)

```json
{
  "email": "kauan@email.com",
  "password": "123456"
}
```

Vai retornar um token JWT.

### 5. Testar endpoints protegidos

Copie o token retornado e cole no botão "Authorize" do Swagger, usando o padrão:

```
Bearer SEU_TOKEN
```

#### Endpoints disponíveis:

- `GET /users/all` → só `admin`
- `DELETE /users/{id}` → só `admin`

## Banco H2

Se quiser ver os dados salvos, acesse:

[http://localhost:8080/h2-console](http://localhost:8080/h2-console)

- JDBC URL: `jdbc:h2:mem:testdb`
- Usuário: `sa`
- Senha: (deixa em branco)

## Observações

- Todos os dados são apagados quando reinicia o projeto
- Lombok precisa estar instalado no IntelliJ
- Projeto preparado para conectar num banco real depois se quiser

---

Feito por Kauan Bertalha ✌️
