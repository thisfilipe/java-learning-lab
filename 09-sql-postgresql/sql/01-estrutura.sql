-- ETAPA 1: SQL declarativa, DDL e integridade
--
-- Ainda não escreva todas as tabelas de uma vez.
-- Começaremos pela tabela clientes, seguindo o primeiro exercício dado na
-- conversa.

-- EXERCÍCIO 1
-- Crie a tabela clientes com estas regras:
--
-- 1. id: número inteiro grande, gerado automaticamente e chave primária;
-- 2. nome: texto de até 100 caracteres, obrigatório;
-- 3. email: texto de até 150 caracteres, obrigatório e não repetido;
-- 4. ativo: verdadeiro/falso, obrigatório e verdadeiro por padrão;
-- 5. criado_em: data e hora, obrigatório e preenchido com o instante atual
--    por padrão.
--
-- Escreva seu CREATE TABLE abaixo desta linha.

CREATE TABLE clientes (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    ativo BOOLEAN NOT NULL DEFAULT true,
    criado_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- EXERCÍCIO 2
-- Altere a tabela clientes para adicionar a coluna telefone.
-- Ela deve aceitar texto de até 20 caracteres e ser opcional.
-- Escreva um ALTER TABLE abaixo desta linha.

ALTER TABLE clientes
ADD COLUMN telefone VARCHAR(20);

-- EXERCÍCIO 3
-- Crie a tabela produtos com estas regras:
--
-- 1. id: BIGINT gerado automaticamente e chave primária;
-- 2. nome: texto de até 100 caracteres, obrigatório;
-- 3. categoria: texto de até 50 caracteres, obrigatório;
-- 4. preco: número com até 10 algarismos no total e 2 casas decimais,
--    obrigatório e maior que zero;
-- 5. estoque: número inteiro, obrigatório, zero por padrão e nunca negativo.
--
-- Use duas restrições CHECK: uma para preco e outra para estoque.

CREATE TABLE produtos (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    preco NUMERIC(10, 2) NOT NULL CHECK (preco > 0),
    estoque INT NOT NULL DEFAULT 0 CHECK (estoque >= 0)
);

-- EXERCÍCIO 4
-- Crie a tabela pedidos com estas regras:
--
-- 1. id: BIGINT gerado automaticamente e chave primária;
-- 2. cliente_id: BIGINT obrigatório e chave estrangeira para clientes(id);
-- 3. criado_em: TIMESTAMP obrigatório, com o instante atual por padrão;
-- 4. status: texto de até 20 caracteres, obrigatório, 'PENDENTE' por padrão e
--    limitado pelo CHECK aos valores 'PENDENTE', 'PAGO' ou 'CANCELADO'.

CREATE TABLE pedidos (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    cliente_id BIGINT NOT NULL REFERENCES clientes(id),
    criado_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDENTE' CHECK (
        status IN ('PENDENTE', 'PAGO', 'CANCELADO')
        )
);

-- EXERCÍCIO 5
-- Crie a tabela itens_pedido com estas regras:
--
-- 1. pedido_id: BIGINT obrigatório e FK para pedidos(id);
-- 2. produto_id: BIGINT obrigatório e FK para produtos(id);
-- 3. quantidade: INTEGER obrigatório e maior que zero;
-- 4. preco_unitario: NUMERIC(10, 2) obrigatório e maior que zero;
-- 5. a chave primária deve ser composta por (pedido_id, produto_id).
--
-- Não crie uma coluna id. A chave composta impede repetir o mesmo produto
-- dentro do mesmo pedido.

CREATE TABLE itens_pedido (
    pedido_id BIGINT NOT NULL REFERENCES pedidos(id),
    produto_id BIGINT NOT NULL REFERENCES produtos(id),
    quantidade INT NOT NULL CHECK (quantidade > 0),
    preco_unitario NUMERIC(10, 2) NOT NULL CHECK (preco_unitario > 0),
    PRIMARY KEY (pedido_id, produto_id)
);
