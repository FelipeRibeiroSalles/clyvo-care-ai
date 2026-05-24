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
