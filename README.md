# API de Gerenciamento de Produtos

API REST desenvolvida com Spring Boot 3 para gerenciamento de produtos, incluindo operações CRUD (Create, Read, Update, Delete) completas.

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.2.1
- PostgreSQL
- Maven
- Swagger/OpenAPI
- Lombok
- Spring Data JPA

## 📋 Pré-requisitos

Antes de começar, você precisa ter instalado em sua máquina:

- Java Development Kit (JDK) 21
- Maven 3.6.3 ou superior
- PostgreSQL 12 ou superior
- Git (opcional, para clonar o repositório)

## 🔧 Configuração do Ambiente

### 1. Configuração do Banco de Dados

1. Acesse o PostgreSQL:
```bash
sudo -u postgres psql
```

2. Crie um novo banco de dados:
```sql
CREATE DATABASE db_bossabox;
```

3. Crie um usuário (se necessário):
```sql
CREATE USER seu_usuario WITH ENCRYPTED PASSWORD 'sua_senha';
GRANT ALL PRIVILEGES ON DATABASE db_bossabox TO seu_usuario;
```

### 2. Configuração da Aplicação

1. Clone o repositório (ou baixe o ZIP):
```bash
git clone https://github.com/marco-oliveira-s10/api-bossabox.git
cd api-bossabox
```

2. Configure o banco de dados no arquivo `src/main/resources/application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/productdb
    username: seu_usuario
    password: sua_senha
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

## 🚀 Instalação e Execução

1. Compile o projeto:
```bash
mvn clean install
```

2. Execute a aplicação:
```bash
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`

## 📖 Documentação da API (Swagger)

Após iniciar a aplicação, acesse a documentação Swagger UI em:
```
http://localhost:8080/swagger-ui/index.html
```

### Endpoints Disponíveis

- GET `/api/products` - Lista todos os produtos
- GET `/api/products/{id}` - Busca um produto pelo ID
- POST `/api/products` - Cria um novo produto
- PUT `/api/products/{id}` - Atualiza um produto existente
- DELETE `/api/products/{id}` - Remove um produto

### Exemplo de Payload para Criar/Atualizar Produto

```json
{
  "name": "Smartphone XYZ",
  "price": 1999.99,
  "description": "Um smartphone incrível",
  "quantity": 10
}
```

## 🔍 Testando a API

### Usando o Swagger UI

1. Acesse `http://localhost:8080/swagger-ui/index.html`
2. Escolha o endpoint que deseja testar
3. Clique em "Try it out"
4. Preencha os parâmetros necessários
5. Clique em "Execute"

### Usando o Postman

1. Abra o Postman
2. Crie uma nova requisição
3. Use uma das URLs listadas acima
4. Selecione o método HTTP adequado (GET, POST, PUT, DELETE)
5. Para POST e PUT, adicione o JSON no body da requisição
6. Envie a requisição

### Exemplos de Requisições

#### Criar Produto (POST)
```bash
curl -X POST http://localhost:8080/api/products \
-H "Content-Type: application/json" \
-d '{
    "name": "Smartphone XYZ",
    "price": 1999.99,
    "description": "Um smartphone incrível",
    "quantity": 10
}'
```

#### Listar Produtos (GET)
```bash
curl http://localhost:8080/api/products
```

## 🛠 Solução de Problemas

1. **Erro de conexão com banco de dados**
   - Verifique se o PostgreSQL está rodando
   - Confirme as credenciais no application.yml
   - Verifique se o banco de dados foi criado

2. **Erro ao iniciar a aplicação**
   - Verifique se a porta 8080 está disponível
   - Confirme se o Java 21 está instalado corretamente

3. **Swagger não carrega**
   - Limpe o cache do navegador
   - Verifique se a aplicação está rodando
   - Tente acessar /v3/api-docs para verificar se a documentação está sendo gerada

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Notas Adicionais

- A aplicação usa o Hibernate para criar automaticamente as tabelas no banco de dados
- O Swagger UI oferece uma interface interativa para testar todos os endpoints
- Todas as respostas da API são em formato JSON
- Os erros são tratados globalmente e retornam mensagens apropriadas

## 📫 Suporte

Em caso de dúvidas ou problemas, abra uma issue no repositório ou entre em contato com a equipe de desenvolvimento.
