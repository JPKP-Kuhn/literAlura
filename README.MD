# 📚 LiterAlura

**LiterAlura** é um projeto desenvolvido como parte do **challenge LiterAlura**, promovido pela Alura em parceria com o programa **Oracle Next Education**. Esta aplicação permite buscar e registrar livros utilizando a **API Gutendex** e armazenar as informações de forma persistente em um banco de dados **PostgreSQL**.

## 🛠️ Tecnologias Utilizadas

- **Linguagem de Programação**: Java
- **Framework**: Spring Boot
- **Gerenciamento de Dependências**: Maven
- **Banco de Dados**: PostgreSQL
- **API Externa**: [Gutendex](https://gutendex.com/)
- **Tecnologia de Persistência**: Spring Data JPA

## 📦 Dependências

### No arquivo `pom.xml` do projeto, você encontrará as seguintes dependências:

- **Spring Boot Starter Web**: Para criação da API REST.
- **Spring Data JPA**: Para facilitar a integração com o banco de dados PostgreSQL.
- **PostgreSQL Driver**: Para conectar a aplicação ao banco de dados PostgreSQL.

## 🌍 Funcionalidades

A aplicação consome a API **Gutendex** para realizar as seguintes operações:

### 1. Buscar Livros por Título
O usuário pode inserir o título de um livro, e a aplicação realiza uma busca na API **Gutendex** para retornar informações como título, autor, idioma e número de downloads.

### 2. Armazenar Livros no Banco de Dados
Caso o livro não tenha sido previamente registrado, os dados obtidos da API são armazenados no banco de dados PostgreSQL, incluindo informações como:

- Título
- Autor
- Idioma
- Número de downloads

### 3. Listar Livros Registrados
O usuário pode visualizar todos os livros registrados no banco de dados.

### 4. Listar Autores Registrados
A aplicação permite listar todos os autores dos livros armazenados no banco de dados.

### 5. Listar Autores Vivos em um Ano Específico
O usuário pode inserir um ano, e a aplicação exibe todos os autores que estavam vivos nesse ano.

### 6. Listar Livros em um Idioma Específico
A aplicação permite ao usuário listar todos os livros disponíveis em um idioma específico.

