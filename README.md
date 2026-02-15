📌 API de Clientes com Integração ViaCEP

Esta é uma API REST desenvolvida com Spring Boot para gerenciamento de clientes.
A aplicação realiza operações completas de CRUD e integra com a API pública ViaCEP para buscar automaticamente os dados de endereço a partir do CEP informado.


📂 Estrutura do Projeto

A aplicação segue a arquitetura em camadas:

controller → service → repository → entity(model)

📂

Controller → Responsável pelas requisições HTTP

Service → Regras de negócio

Repository → Comunicação com o banco de dados

Entity → Representação das tabelas

🔥 Funcionalidades

✅ Criar cliente
✅ Listar clientes
✅ Buscar cliente por ID
✅ Atualizar cliente
✅ Deletar cliente
✅ Integração automática com ViaCEP
✅ Evita duplicação de endereços no banco

📮 Exemplo de Requisição (POST)

Endpoint:

POST /clientes

Body JSON:

{
  "nome": "Yasmim",
  "endereco": {
    "cep": "01001000"
  }
}


Ao receber o CEP, a API:

Verifica se o endereço já existe no banco

Caso não exista, consulta o ViaCEP

Salva o endereço

Associa ao cliente

▶️ Como Rodar o Projeto

Clone o repositório:

git clone https://github.com/YasmimMatosLi/project-springboot-api-viacep.git


📌 Endpoint Principal
http://localhost:8080/clientes

🧠 Conceitos Aplicados

- Arquitetura em Camadas

- Injeção de Dependência

- Integração com API externa

- Persistência com JPA

- Relacionamento @ManyToOne

- Tratamento de Optional

📎

Desenvolvido para fins de estudo e prática com Spring Boot e integração de APIs externas.
