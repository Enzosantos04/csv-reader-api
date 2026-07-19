# CSV Reader API

API REST em Spring Boot para importar produtos a partir de arquivos CSV e listá-los com paginação.

## Tecnologias

- Java 17
- Spring Boot 4.1
- Spring Data JPA
- PostgreSQL
- Flyway
- OpenCSV
- Docker Compose
- Maven
- Lombok

## Funcionalidades

- Importação de produtos via upload de arquivo CSV
- Persistência em lote (batch de 500 registros)
- Listagem paginada de produtos
- Migrações de banco com Flyway

## Pré-requisitos

- Java 17+
- Maven 3.8+ (ou use o wrapper `./mvnw`)
- Docker e Docker Compose

## Configuração

Crie um arquivo `.env` na raiz do projeto com as variáveis do PostgreSQL e da aplicação:

```env
POSTGRES_DB=nome_do_banco
POSTGRES_USER=postgres
POSTGRES_PASSWORD=sua_senha

DATABASE_URL=jdbc:postgresql://localhost:5431/nome_do_banco
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=sua_senha
```

## Subindo o banco de dados

```bash
docker compose up -d
```

## Executando a aplicação

```bash
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`.

## Formato do CSV

O arquivo deve conter o cabeçalho abaixo (separado por vírgula):

```csv
nome do produto,preco,quantidade
Notebook Dell,3500.00,10
Mouse Logitech,120.50,50
Teclado Mecânico,450.00,25
```

| Coluna           | Tipo    | Descrição              |
|------------------|---------|------------------------|
| nome do produto  | String  | Nome do produto        |
| preco            | Decimal | Preço unitário         |
| quantidade       | Inteiro | Quantidade em estoque  |

## Endpoints

### Importar CSV

```http
POST /import-csv
Content-Type: multipart/form-data
```

| Parâmetro | Tipo | Obrigatório | Descrição        |
|-----------|------|-------------|------------------|
| file      | File | Sim         | Arquivo `.csv`   |



### Listar produtos

```http
GET /products
```

**Exemplo de resposta:**

```json
{
  "content": [
    {
      "id": 1,
      "nome": "Notebook Dell",
      "preco": 3500.00,
      "quantidade": 10
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10
  },
  "totalElements": 1,
  "totalPages": 1
}
```

## Estrutura do projeto

```text
src/main/java/enzosdev/csvreaderapi/
├── controller/     # Endpoints REST
├── service/        # Regras de negócio e importação CSV
├── repository/     # Acesso a dados (JPA)
├── entity/         # Entidades do banco
├── dto/            # DTOs de entrada/saída
├── mapper/         # Conversão DTO ↔ Entity
└── CsvreaderapiApplication.java

src/main/resources/
├── application.yaml
└── db/migration/   # Scripts Flyway
```


## Licença

Este projeto é de uso livre para fins de estudo e desenvolvimento.
