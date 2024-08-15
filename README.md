# Happy Adoption API

Esta é uma API construída com Java 17+, documentada usando Swagger, utilizando Docker para orquestração de contêineres, e com suporte a banco de dados PostgreSQL.

## Pré-requisitos

- [Java](https://www.java.com/pt-BR/)
- [Swagger](https://swagger.io/)
- [Docker](https://www.docker.com/)
- [PostgreSQL](https://www.postgresql.org/)

## Configuração

### Instalação

1. Clone este repositório:

   ```bash
   git clone git@github.com:DilanLopezN/HappyAdoption.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd sua-api
   ```
## Uso

### Com Docker

1. Inicie os contêineres Docker:

   ```bash
   docker-compose up -d
   ```

3. Rode o projeto:

   ```bash
   mvn spring-boot:run
   ```

2. Acesse a API em [http://localhost:8080](http://localhost:8080)

3. Acesse a documentação Swagger em [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Este projeto está licenciado sob a [Licença MIT](LICENSE)