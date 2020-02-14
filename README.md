# shortest-path-api
API REST responsável em listar o menor caminho entre dois pontos.

## Sobre

Este projeto tem como objetivo utilizar o algoritmo de menor caminho criado por Edsger Dijkstra.

A API irá retornar a rota que terá menor custo entre dois pontos.

## Criado com

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[H2](https://www.h2database.com/html/main.html) - Relational Database Management System
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system 
* 	[Lombok](https://projectlombok.org/) - Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.
* 	[Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.

## Ferramentas externas

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)

### Pré-requisitos

Para instalar e executar a API é preciso instalar:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [GIT](https://git-scm.com/downloads)

## Executando a aplicação local

Primeiramente, deve-se realizar o clone do projeto através do comando:

```sh
git clone https://github.com/LucasES/shortest-path-api.git
```

Ou acessar a URL: https://github.com/LucasES/shortest-path-api e realizar o download do projeto no formato zip e realizar a extração do arquivo.

Existem várias maneiras de executar um aplicativo Spring Boot em sua máquina local. Uma maneira é executar o método `main` na classe `br.com.shortestpathapi.ShortestPathApiApplication` do IDE.

Como alternativa, você pode usar o [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) e executar o seguinte comando:

```shell
mvn spring-boot:run
```

### Swagger

A documentação da API poderá ser acessada após a execução do projeto na seguinte URL:

```sh
http://localhost:8080/shortest-path-api/swagger-ui.html
```

### URL's

|  URL |  Método | 
|----------|--------------|
|`http://localhost:8080/shortest-path-api/v1/distance`                           | POST |
 
 ## Arquivos e diretórios
 
 O projeto shortest-path-api possui uma estrutura de diretórios específica. 
 
 Um projeto representativo é representado abaixo:
 
 ```
 .
 ├── Spring Elements
 ├── src
 │   └── main
 │       └── java
 │           ├── br.com.shortestpathapi.ShortestPathApiApplication
 │           ├── br.com.shortestpathapi.config
 │           ├── br.com.shortestpathapi.controller
 │           ├── br.com.shortestpathapi.model
 │           ├── br.com.shortestpathapi.repository
 │           └── br.com.shortestpathapi.service
 ├── src
 │   └── main
 │       └── resources
 │           ├── application.properties
 │           ├── banner.txt
 │           └── log4j2.xml
 ├── src
 │   └── test
 │       └── java
 ├── JRE System Library
 ├── Maven Dependencies
 ├── bin
 ├── src
 ├── target
 │   └──shortest-path-api-0.1.0
 ├── mvnw
 ├── mvnw.cmd
 ├── pom.xml
 └── README.md
 ```
## Pacotes

- `models` — Camada de modelo responsável em centralizar as entidades do projeto;
- `repositories` — Camada responsável para se comunicar com o banco de dados;
- `services` — Camada responsável em centralizar a lógica de negócio do sistema;
- `controllers` — Camada responsável em externalizar as API's;
- `resources/` - Contém todos os recursos estáticos, modelos e arquivos de propriedades.
- `resources/application.properties` - Ele contém propriedades para todo o aplicativo. O Spring lê as propriedades definidas neste arquivo para configurar seu aplicativo. Você pode definir a porta padrão do servidor, o caminho de contexto do servidor, os URLs do banco de dados etc., neste arquivo.

- `test/` - centraliza os testes unitários do projeto

- `pom.xml` - arquivo responsável em centralizar as dependências do projeto.
## Contribuição

Por favor, leia [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) para obter detalhes sobre nosso código de conduta e o processo de envio de solicitações pull requests.

## Autores

* **Lucas Araújo** - *projeto inicial* - [LucasES](https://github.com/LucasES)

## Licença

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

