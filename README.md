# DSList

Projeto desenvolvido durante o programa "Intensivão Java Spring" ministrado pelo professor [Nelio Alves](https://github.com/acenelio). O objetivo da aplicação é gerenciar listas de jogos, permitindo a visualização e a movimentação de jogos dentro das listas.

## Tecnologias Utilizadas

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![JPA / Hibernate](https://img.shields.io/badge/JPA%20/%20Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![Banco de Dados SQL](https://img.shields.io/badge/SQL-4479A1?style=for-the-badge&logo=postgresql&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)

## Funcionalidades

- Listar todas as listas de jogos
- Listar jogos por lista
- Mover jogos dentro de uma lista

## Estrutura do Projeto

- `src/main/java/com/devsuperior/dslist/controllers`: Contém os controladores REST para gerenciar as requisições HTTP.
- `src/main/java/com/devsuperior/dslist/dto`: Contém as classes DTO (Data Transfer Object) utilizadas para transferir dados entre as camadas do sistema.
- `src/main/java/com/devsuperior/dslist/entities`: Contém as entidades JPA que representam as tabelas do banco de dados.
- `src/main/java/com/devsuperior/dslist/repositories`: Contém os repositórios JPA para acesso ao banco de dados.
- `src/main/java/com/devsuperior/dslist/services`: Contém as classes de serviço que implementam a lógica de negócio.

## Endpoints

- `GET /lists`: Retorna todas as listas de jogos.
- `GET /lists/{listId}/games`: Retorna todos os jogos de uma lista específica.
- `POST /lists/{listId}/replacement`: Move um jogo dentro de uma lista.