# 📋 To-Do API Java

API REST para gerenciamento de tarefas, construída com **Java + Spring Boot**, aplicando arquitetura em camadas, boas práticas de Clean Code e testes automatizados.

> Releitura em Java do projeto [Python-ToDo-API](https://github.com/jsantana-dev/Python-ToDo-API), desenvolvida como parte do meu aprendizado prático em Spring Boot.

---

## 🚀 Tecnologias utilizadas

- **Java 25**
- **Spring Boot** — Spring Web, Spring Data JPA
- **H2 Database** — banco de dados relacional em memória
- **JUnit 5 + Mockito** — testes unitários
- **Maven** — gerenciador de dependências
- **Hibernate** — ORM (mapeamento objeto-relacional)

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas, separando claramente as responsabilidades:

```
src/main/java/todo_api_java/
├── model/            → Entidades de domínio (Tarefa, Status)
├── repository/        → Interface de acesso a dados (JpaRepository)
├── service/            → Contrato da lógica de negócio (interface)
│   └── impl/           → Implementação da lógica de negócio
├── controller/         → Endpoints REST
└── exception/          → Exceções customizadas + tratamento global de erros
```

**Por que essa separação?**
Cada camada tem uma única responsabilidade: o `Controller` cuida de requisições HTTP, o `Service` cuida das regras de negócio, e o `Repository` cuida da persistência. Isso torna o código mais fácil de testar, manter e evoluir — além de refletir o padrão utilizado em projetos profissionais.

---

## 📌 Endpoints disponíveis

| Método | Rota                     | Descrição                          |
|--------|--------------------------|--------------------------------------|
| POST   | `/tarefas`                | Cria uma nova tarefa                |
| GET    | `/tarefas`                | Lista todas as tarefas              |
| GET    | `/tarefas/{id}`            | Busca uma tarefa pelo id            |
| PUT    | `/tarefas/{id}`            | Atualiza título e descrição         |
| PATCH  | `/tarefas/{id}/completar`  | Marca uma tarefa como concluída     |
| DELETE | `/tarefas/{id}`            | Remove uma tarefa                   |

### Exemplo de requisição (POST)

```json
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Revisar conceitos de injeção de dependência"
}
```

### Exemplo de resposta

```json
{
  "id": 1,
  "titulo": "Estudar Spring Boot",
  "descricao": "Revisar conceitos de injeção de dependência",
  "status": "PENDENTE",
  "dataCriacao": "2026-08-19T18:21:40.369"
}
```

### Exemplo de erro (404)

```json
{
  "status": 404,
  "mensagem": "Tarefa não encontrada com id: 999",
  "timestamp": "2026-08-19T19:04:09.988"
}
```

---

## ✅ Boas práticas aplicadas

- Injeção de dependência via construtor
- Separação de contrato e implementação (`interface` + `impl`)
- Tratamento global de exceções com `@RestControllerAdvice`
- Uso de `Optional` para tratar ausência de dados de forma segura
- Enum ao invés de `String` solta, evitando valores inválidos
- Encapsulamento (atributos protegidos, sem setters onde não fazia sentido)
- Testes unitários com mocks, isolando a lógica de negócio do banco de dados

---

## 🧪 Testes

O projeto conta com testes unitários da camada de serviço, utilizando **Mockito** para simular o repositório e isolar a lógica de negócio:

- ✅ Deve criar tarefa com status `PENDENTE`
- ✅ Deve lançar `TarefaNaoEncontradaException` ao buscar um id inexistente

Para rodar os testes:

```bash
./mvnw test
```

---

## ▶️ Como rodar o projeto

**Pré-requisitos:** Java 21+ e Maven (ou use o wrapper `./mvnw` incluso no projeto).

```bash
# Clone o repositório
git clone https://github.com/jsantana-dev/todo-api-java.git

# Entre na pasta
cd todo-api-java

# Rode a aplicação
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080/tarefas`.

O console do banco H2 pode ser acessado em `http://localhost:8080/h2-console`, com:
- **JDBC URL:** `jdbc:h2:mem:tododb`
- **Usuário:** `sa`
- **Senha:** *(em branco)*

---

## 🔭 Próximos passos

- [ ] DTOs para separar dados de entrada/saída da entidade
- [ ] Testes de integração com `MockMvc` e `@DataJpaTest`
- [ ] Documentação interativa com Swagger/OpenAPI
- [ ] Perfis de ambiente (dev/prod)

---

## 👩‍💻 Autora

**Jamylle Santana**
[LinkedIn](https://www.linkedin.com/in/jamylle-santana) 
