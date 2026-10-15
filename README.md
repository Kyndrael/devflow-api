# DevFlow API

API REST de gerenciamento de tarefas construída com Java 17, Spring Boot, Spring Data JPA e PostgreSQL (ou H2 para execução local rápida). Projeto educacional para demonstrar padrões GoF aplicados a um caso real.

## Funcionalidades

- CRUD de tarefas
- Status `TODO`, `IN_PROGRESS`, `DONE`
- Prioridades `LOW`, `MEDIUM`, `HIGH`, `URGENT`
- Filtro por status e ordenação por prioridade, prazo ou criação
- Validação de entrada e respostas de erro padronizadas
- Swagger/OpenAPI
- Teste de integração com MockMvc
- Docker Compose com PostgreSQL

## Padrões demonstrados

- **Strategy:** estratégias de ordenação (`priority`, `dueDate`, `createdAt`).
- **Chain of Responsibility:** cadeia de validações antes de criar/atualizar tarefas.
- **Factory:** `TaskFactory` centraliza a criação da entidade.
- **Observer:** eventos publicados com `ApplicationEventPublisher` e recebidos por `@EventListener`.
- **Singleton (Spring):** componentes `@Service`, `@Component` e `@Repository` são normalmente beans singleton por padrão. Não foi criado um Singleton manual, pois o contêiner Spring já administra esse ciclo de vida.

> A cadeia de validação deste exemplo é pequena e didática. Em um sistema maior, vale compor os handlers por configuração para que a ordem seja explícita e extensível.

## Requisitos

- JDK 17+
- Maven 3.9+ (para execução local), ou Docker com Compose

## Executar localmente (H2 em memória)

Na raiz do projeto:

```bash
mvn spring-boot:run
```

A API ficará em `http://localhost:8080`. O banco H2 é em memória e perde os dados ao reiniciar a aplicação.

- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs
- Console H2: http://localhost:8080/h2-console (JDBC URL `jdbc:h2:mem:devflow`, usuário `sa`, senha vazia)

## Executar com PostgreSQL via Docker

```bash
docker compose up --build
```

A API ficará em `http://localhost:8080` e os dados serão persistidos no volume `devflow_data`.

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/api/tasks` | Criar tarefa |
| `GET` | `/api/tasks` | Listar; aceita `status` e `orderBy` |
| `GET` | `/api/tasks/{id}` | Buscar por ID |
| `PUT` | `/api/tasks/{id}` | Atualizar tarefa |
| `PATCH` | `/api/tasks/{id}/status` | Atualizar status |
| `DELETE` | `/api/tasks/{id}` | Excluir tarefa |

Valores para `status`: `TODO`, `IN_PROGRESS`, `DONE`.
Valores para `orderBy`: `priority`, `dueDate`, `createdAt`.

### Criar tarefa

```bash
curl -X POST http://localhost:8080/api/tasks ^
  -H "Content-Type: application/json" ^
  -d "{\"title\":\"Estudar Design Patterns\",\"description\":\"Implementar Strategy\",\"priority\":\"HIGH\",\"dueDate\":\"2027-01-30\"}"
```

No PowerShell, se preferir, use `curl.exe` ou o Swagger UI. Exemplo de JSON:

```json
{
  "title": "Estudar Design Patterns",
  "description": "Implementar Strategy",
  "priority": "HIGH",
  "dueDate": "2027-01-30"
}
```

### Filtrar e ordenar

```http
GET /api/tasks?status=TODO&orderBy=dueDate
```

### Alterar status

```json
{ "status": "DONE" }
```

Envie esse corpo para `PATCH /api/tasks/1/status`.

## Testes

```bash
mvn test
```

## Próximas melhorias recomendadas

- Autenticação/autorização com Spring Security e JWT
- Paginação com `Pageable`
- Migrações de banco com Flyway
- Notificações reais por e-mail
- CI com GitHub Actions
- Perfis de configuração e logs estruturados
