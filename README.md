# 📚 Literaula

Aplicação desenvolvida em **Java com Spring Boot** que consome a API pública **Gutendex** para buscar livros, salvar no banco de dados e permitir consultas tanto via **console interativo** quanto via **API REST**.

Projeto criado com foco em aprendizado prático de:
- Consumo de APIs externas
- Arquitetura em camadas
- Spring Data JPA
- Integração com banco de dados
- Uso de menu via terminal

---

## 🚀 Funcionalidades

- 🔎 Buscar livros na API Gutendex pelo título
- 💾 Salvar livros automaticamente no banco de dados
- 📄 Listar livros salvos
- 🖥️ Menu interativo no console
- 🌐 Endpoint REST para busca de livros

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.2**
- Spring Web
- Spring Data JPA
- PostgreSQL
- API Gutendex
- Maven
- Git / GitHub

---

## 🧱 Arquitetura do Projeto

```text
com.example.literaula2
│
├── controller      → Endpoints REST
├── service         → Regras de negócio
├── client          → Consumo da API Gutendex
├── repository      → Acesso ao banco de dados
├── model           → Entidades JPA
├── console         → Menu interativo no terminal
└── Literaula2Application.java
