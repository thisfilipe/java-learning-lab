-- ETAPA 2: DML e consultas básicas
-- INSERT, UPDATE, DELETE, SELECT, WHERE e ORDER BY.

-- EXERCÍCIO 1
-- Insira uma cliente com estes dados:
--
-- nome: Ana Souza
-- email: ana@exemplo.com
-- telefone: não informado
--
-- Informe no INSERT somente as colunas nome e email. Assim poderemos observar
-- o id automático, os valores padrão e o telefone opcional.

INSERT INTO clientes (nome, email)
VALUES ('Ana Souza', 'ana@exemplo.com');

-- EXERCÍCIO 2
-- Tente inserir outro cliente com:
--
-- nome: Ana Repetida
-- email: ana@exemplo.com
--
-- O e-mail já pertence à primeira linha. Escreva o novo INSERT abaixo para
-- observar a restrição UNIQUE em ação.

/* 
INSERT INTO clientes (nome, email)
VALUES ('Ana Repetida', 'ana@exemplo.com');
*/

-- EXERCÍCIO 3
-- Primeiro, transforme em comentários as duas linhas do INSERT inválido acima.
-- Ele já cumpriu o papel de demonstrar a restrição UNIQUE.
--
-- Depois escreva três INSERTs separados para cadastrar:
--
-- 1. Bruno Lima, bruno@exemplo.com, telefone 85999990001
-- 2. Carla Mendes, carla@exemplo.com, sem telefone
-- 3. Diego Alves, diego@exemplo.com, telefone 85999990003

INSERT INTO clientes (nome, email, telefone)
VALUES ('Bruno Lima','bruno@exemplo.com', '85999990001');

INSERT INTO clientes (nome, email)
VALUES ('Carla Mendes', 'carla@exemplo.com');

INSERT INTO clientes (nome, email, telefone)
VALUES ('Diego Alves', 'diego@exemplo.com', '85999990003');

-- EXERCÍCIO 4
-- Consulte somente nome, email e telefone dos clientes que possuem telefone.
-- Ordene o resultado pelo nome em ordem decrescente.

SELECT nome, email, telefone
FROM clientes
WHERE telefone IS NOT NULL
ORDER BY nome DESC;

-- EXERCÍCIO 5
-- Altere o cliente cujo email é diego@exemplo.com para ativo = false.
-- Use WHERE para que somente esse cliente seja atualizado.

UPDATE clientes
SET ativo = false
WHERE email = 'diego@exemplo.com';

-- EXERCÍCIO 6
-- Exclua da tabela clientes somente os registros cujo ativo seja false.
-- Use WHERE para preservar os clientes ativos.

DELETE FROM clientes
WHERE ativo = false;

-- EXERCÍCIO 7
-- Insira estes quatro produtos usando quatro comandos INSERT:
--
-- 1. Teclado Mecânico | Periféricos | 250.00 | estoque 10
-- 2. Mouse sem Fio     | Periféricos | 120.00 | estoque 20
-- 3. Monitor 24        | Monitores   | 900.00 | estoque 8
-- 4. Suporte de Mesa   | Acessórios  | 150.00 | estoque 12

INSERT INTO produtos (nome, categoria, preco, estoque)
VALUES ('Teclado Mecânico', 'Periféricos', 250.00, 10);

INSERT INTO produtos (nome, categoria, preco, estoque)
VALUES ('Mouse sem Fio', 'Periféricos', 120.00, 20);

INSERT INTO produtos (nome, categoria, preco, estoque)
VALUES ('Monitor 24', 'Monitores', 900.00, 8);

INSERT INTO produtos (nome, categoria, preco, estoque)
VALUES ('Suporte de Mesa', 'Acessórios', 150.00, 12);

-- EXERCÍCIO 8
-- Insira três pedidos:
--
-- 1. cliente_id 1 (Ana), status PAGO;
-- 2. cliente_id 1 (Ana), sem informar status, para usar o padrão PENDENTE;
-- 3. cliente_id 3 (Bruno), status PAGO.
--
-- criado_em deve ser omitido nos três casos.

INSERT INTO pedidos (cliente_id, status)
VALUES (1, 'PAGO');

INSERT INTO pedidos (cliente_id)
VALUES (1);

INSERT INTO pedidos (cliente_id, status)
VALUES (3, 'PAGO');

-- EXERCÍCIO 9
-- Insira os itens abaixo em itens_pedido:
--
-- pedido 1 | produto 1 | quantidade 1 | preco_unitario 250.00
-- pedido 1 | produto 2 | quantidade 2 | preco_unitario 120.00
-- pedido 2 | produto 3 | quantidade 1 | preco_unitario 900.00
-- pedido 3 | produto 2 | quantidade 1 | preco_unitario 120.00
-- pedido 3 | produto 4 | quantidade 2 | preco_unitario 150.00
--
-- Use cinco INSERTs. As colunas são pedido_id, produto_id, quantidade e
-- preco_unitario.

INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, preco_unitario)
VALUES (1, 1, 1, 250.00);

INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, preco_unitario)
VALUES (1, 2, 2, 120.00);

INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, preco_unitario)
VALUES (2, 3, 1, 900.00);

INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, preco_unitario)
VALUES (3, 2, 1, 120.00);

INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, preco_unitario)
VALUES (3, 4, 2, 150.00);
