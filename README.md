# 🧊 MagicFridgeIA

API inteligente desenvolvida com Java e Spring Boot que gera sugestões de receitas com base nos alimentos cadastrados na geladeira do usuário utilizando integração com IA.

O projeto permite cadastrar ingredientes disponíveis e utilizar inteligência artificial para recomendar receitas de forma automática.

---

# 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring WebFlux
- Spring WebClient
- Spring Data JPA
- Hibernate
- Flyway
- H2 Database
- Lombok
- Maven

---

# 🤖 Funcionalidades

## 🥬 Gerenciamento de Ingredientes
- Cadastrar alimentos
- Listar alimentos cadastrados
- Atualizar alimentos
- Remover alimentos
- Controle de quantidade
- Controle de validade

---

## 🍳 Geração de Receitas com IA
- Envio dos ingredientes cadastrados para IA
- Geração automática de receitas
- Sugestões inteligentes baseadas nos alimentos disponíveis
- Resposta em formato estruturado

---

# 🧱 Arquitetura do Projeto

O projeto segue arquitetura em camadas:

```txt
Controller → Service → Repository → Database
```

Organização:
- Controller
- Service
- Repository
- DTO
- Config
- Model

---

# 🗂️ Estrutura da Entidade

## 🥬 FoodItem

| Campo | Tipo |
|---|---|
| id | Long |
| nome | String |
| categoria | Enum |
| quantidade | Integer |
| validade | LocalDate |

---

# 📦 Categorias de Ingredientes

```java
FRUTA,
VERDURA,
LEGUME,
CARNE,
LATICINIO
```

---

# 🛠️ Dependências Principais

```xml
Spring WebFlux
Spring WebClient
Spring Data JPA
Flyway
H2 Database
Lombok
```

---

# ⚙️ Como Executar o Projeto

## ✅ Pré-requisitos

- Java 17+
- Maven

---

## 📥 Clonar o repositório

```bash
git clone https://github.com/DevLuizEduardo/MagicFridgeIA.git
```

---

## 📂 Entrar na pasta do projeto

```bash
cd MagicFridgeIA
```

---

## ▶️ Executar a aplicação

```bash
mvn spring-boot:run
```

---

# 🛢️ Banco de Dados H2

O projeto utiliza banco H2 em memória.

## 🔗 Console H2

```txt
http://localhost:8080/h2-console
```

---

## ⚙️ Configuração padrão

```txt
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
```

---

# 📡 Endpoints da API

## 🥬 Food Items

| Método | Endpoint | Descrição |
|---|---|---|
| POST | /food-items | Cadastrar alimento |
| GET | /food-items | Listar alimentos |
| GET | /food-items/{id} | Buscar alimento por ID |
| PUT | /food-items/{id} | Atualizar alimento |
| DELETE | /food-items/{id} | Remover alimento |

---

## 🤖 IA de Receitas

| Método | Endpoint | Descrição |
|---|---|---|
| POST | /recipes/generate | Gerar receita com IA |

---

# 🧪 Exemplo de JSON

## 🥬 Cadastro de Ingrediente

```json
{
  "nome": "Frango",
  "categoria": "CARNE",
  "quantidade": 2,
  "validade": "2026-06-10"
}
```

---

## 🤖 Resposta da Receita

```json
{
  "titulo": "Frango com Legumes",
  "ingredientes": [
    "Frango",
    "Cenoura",
    "Batata"
  ],
  "modoPreparo": [
    "Corte os ingredientes",
    "Refogue o frango",
    "Adicione os legumes"
  ]
}
```

---

# 🌐 Integração com IA

O projeto utiliza:
- WebClient
- Programação Reativa
- Requisições HTTP assíncronas
- Integração com APIs externas de IA

---

# 🧠 Conceitos Aplicados

- API REST
- Spring WebFlux
- Programação Reativa
- WebClient
- Integração com IA
- DTO Pattern
- Arquitetura em camadas
- JPA/Hibernate
- Flyway
- Persistência de dados
- Boas práticas no backend Java

---

# 🚀 Melhorias Futuras

- Autenticação JWT
- Docker
- PostgreSQL
- Cache com Redis
- Upload de imagens dos alimentos
- Geração de receitas por dieta
- Histórico de receitas
- Favoritar receitas
- Deploy em nuvem

---

# 👨‍💻 Autor

Desenvolvido por **Luiz Eduardo** 🚀

- GitHub: https://github.com/DevLuizEduardo

---

# ⭐ Objetivo do Projeto

Este projeto foi desenvolvido com foco em aprendizado de:
- Spring WebFlux
- WebClient
- Integração com APIs externas
- Programação reativa
- Arquitetura backend moderna
- Integração com Inteligência Artificial
