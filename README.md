# 🐾 Clyvo Care AI

Sistema inteligente para gerenciamento clínico veterinário, desenvolvido com Spring Boot, Docker e Azure Cloud Infrastructure.

---

# 📌 Sobre o Projeto

O **Clyvo Care AI** é uma solução voltada ao acompanhamento clínico de pets, permitindo o gerenciamento de:

- Pets
- Tutores
- Clínicas
- Veterinários
- Consultas
- Vacinas
- Medicamentos
- Alertas clínicos
- Histórico clínico
- Score de risco

O projeto foi desenvolvido com foco em:
- escalabilidade
- conteinerização
- cloud computing
- persistência de dados
- arquitetura moderna

---

# 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate
- H2 Database
- Docker
- Docker Compose
- Azure Virtual Machine
- Swagger / OpenAPI

---

# ☁️ Infraestrutura Azure

A aplicação foi hospedada em uma máquina virtual Linux Ubuntu na Microsoft Azure.

## Recursos Utilizados

- Azure Virtual Machine
- Public IP
- Docker Engine
- Docker Compose

---

# 🐳 Containers Docker

A aplicação utiliza dois containers principais:

## API Spring Boot
Responsável pelas regras de negócio e endpoints REST.

## H2 Database
Banco de dados utilizado para persistência e testes da aplicação.

---

# ▶️ How To — Como Executar o Projeto

## 1. Clonar o Repositório

```bash
git clone https://github.com/FelipeRibeiroSalles/clyvo-care-ai.git
```

---

## 2. Entrar na Pasta do Projeto

```bash
cd clyvo-care-ai
```

---

## 3. Gerar o Build da Aplicação

```bash
chmod +x mvnw

./mvnw clean package -DskipTests
```

---

## 4. Executar Containers Docker

```bash
sudo docker-compose up --build -d
```

---

## 5. Verificar Containers em Execução

```bash
sudo docker ps
```

---

# 📘 Swagger OpenAPI

A documentação da API pode ser acessada através do Swagger:

```txt
http://20.63.71.46:8080/swagger-ui/index.html
```

---

# 🗄️ H2 Console

Acesso ao console do banco H2:

```txt
http://20.63.71.46:8080/h2-console
```

## Configuração H2

### JDBC URL

```txt
jdbc:h2:mem:clyvodb
```

### User

```txt
sa
```

### Password

```txt
(deixar vazio)
```


---

# 📂 Estrutura do Projeto

```bash
clyvo-care-ai/
│
├── Dockerfile
├── docker-compose.yml
├── azure-cli-script.sh
├── pom.xml
├── README.md
└── src/


