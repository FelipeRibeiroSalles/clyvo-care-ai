# Clyvo Care AI

API REST desenvolvida em Java com Spring Boot para gerenciamento inteligente de clínicas veterinárias, pets, consultas, vacinas, medicamentos e análise de risco clínico.

Projeto desenvolvido para a disciplina **Java Advanced + Mastering Relational and Non-Relational Database** da FIAP.

---

# Tecnologias Utilizadas

## Backend
- Java 17
- Spring Boot 3.5
- Spring Web
- Spring Data JPA
- Bean Validation

## Banco de Dados
- Oracle Database XE
- Oracle SQL Developer

## Documentação
- Swagger OpenAPI

## Build
- Maven

## Utilitários
- Lombok

---

# Arquitetura do Projeto

O projeto segue arquitetura em camadas:

```text
src/main/java/br/com/clyvocareai
│
├── controller
├── service
├── repository
├── dto
├── model
├── exception
└── config
```

---

# Funcionalidades

## Veterinários
- Cadastro
- Listagem
- Busca por ID

## Clínicas
- Cadastro
- Atualização
- Exclusão
- Paginação

## Tutores
- Cadastro
- Atualização
- Exclusão
- Paginação

## Pets
- Cadastro
- Atualização
- Exclusão
- Busca por tutor
- Busca por nome

## Consultas
- Cadastro
- Listagem
- Exclusão

## Vacinas
- Cadastro
- Controle de status

## Medicamentos
- Cadastro
- Controle terapêutico

## Histórico Clínico
- Registro de eventos médicos

## Alertas
- Alertas veterinários
- Controle de prioridade

## Score de Risco
- Classificação automática:
  - BAIXO
  - MODERADO
  - ALTO
  - CRÍTICO

---

# Banco de Dados Oracle

O projeto utiliza Oracle Database .

## Script SQL

O arquivo completo do banco está disponível em:

```text
script-oracle-clyvo-care-ai.sql
```

O script contém:
- tabelas
- constraints
- triggers
- procedures
- functions
- views
- inserts iniciais

---

# Configuração do application.properties

```properties
spring.application.name=clyvo-care-ai

spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect

springdoc.swagger-ui.path=/swagger
```

---

# Como Executar o Projeto

## 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/clyvo-care-ai.git
```

---

## 2. Abrir no IntelliJ IDEA

Abrir como projeto Maven.

---

## 3. Executar a aplicação

```bash
mvn spring-boot:run
```

ou executar:

```text
ClyvoCareAiApplication.java
```

---

# Swagger

Após iniciar a API:

```text
http://localhost:8080/swagger
```

---

# Principais Endpoints

## Clínicas

| Método | Endpoint |
|---|---|
| POST | /clinicas |
| GET | /clinicas |
| GET | /clinicas/{id} |
| PUT | /clinicas/{id} |
| DELETE | /clinicas/{id} |

---

## Tutores

| Método | Endpoint |
|---|---|
| POST | /tutores |
| GET | /tutores |
| GET | /tutores/{id} |
| PUT | /tutores/{id} |
| DELETE | /tutores/{id} |

---

## Pets

| Método | Endpoint |
|---|---|
| POST | /pets |
| GET | /pets |
| GET | /pets/{id} |
| GET | /pets/tutor/{idTutor} |
| GET | /pets/buscar?nome= |
| PUT | /pets/{id} |
| DELETE | /pets/{id} |

---

## Consultas

| Método | Endpoint |
|---|---|
| POST | /consultas |
| GET | /consultas |
| GET | /consultas/{id} |
| DELETE | /consultas/{id} |

---

# Validações

O projeto possui:
- Bean Validation
- tratamento global de exceções
- mensagens padronizadas
- retorno HTTP adequado

---

# Regras de Negócio

## Score de risco automático

| Score | Classificação |
|---|---|
| 0-25 | BAIXO |
| 26-50 | MODERADO |
| 51-75 | ALTO |
| 76-100 | CRÍTICO |

---

# Desenvolvido por

- João Santana — RM566063
- Felipe Ribeiro — RM565224

Projeto acadêmico — FIAP

---

# Licença

Projeto desenvolvido para fins acadêmicos.