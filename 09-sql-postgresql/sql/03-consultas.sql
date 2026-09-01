-- ETAPA 3: consultas entre tabelas e relatórios
-- JOIN, funções agregadas, GROUP BY, HAVING, subconsulta e UNION.

-- EXERCÍCIO 1: INNER JOIN
-- Liste o id do pedido, o nome do cliente e o status do pedido.
--
-- Comece em pedidos e faça INNER JOIN com clientes.
-- Relacione pedidos.cliente_id com clientes.id.
-- Ordene pelo id do pedido em ordem crescente.

SELECT pedidos.id, clientes.nome, pedidos.status
FROM pedidos
INNER JOIN clientes
    ON pedidos.cliente_id = clientes.id
ORDER BY pedidos.id;

-- EXERCÍCIO 2: LEFT JOIN
-- Liste o nome de todos os clientes, o id e o status de seus pedidos.
--
-- Comece em clientes e faça LEFT JOIN com pedidos.
-- Preserve clientes sem pedido; nesses casos, as colunas do pedido serão NULL.
-- Ordene primeiro por clientes.id e depois por pedidos.id.

SELECT clientes.nome, pedidos.id, pedidos.status
FROM clientes
LEFT JOIN pedidos
    ON clientes.id = pedidos.cliente_id
ORDER BY clientes.id, pedidos.id;

-- EXERCÍCIO 3: múltiplos JOINs
-- Liste, para cada item vendido:
--
-- 1. pedidos.id;
-- 2. clientes.nome;
-- 3. produtos.nome;
-- 4. itens_pedido.quantidade;
-- 5. quantidade * preco_unitario com o nome subtotal.
--
-- Comece em pedidos e faça INNER JOIN, nesta ordem, com clientes,
-- itens_pedido e produtos. Ordene por pedidos.id e produtos.id.

SELECT pedidos.id, clientes.nome, produtos.nome, itens_pedido.quantidade, (itens_pedido.quantidade * itens_pedido.preco_unitario) AS subtotal
FROM pedidos
INNER JOIN clientes
    ON pedidos.cliente_id = clientes.id
INNER JOIN itens_pedido
    ON pedidos.id = itens_pedido.pedido_id
INNER JOIN produtos
    ON itens_pedido.produto_id = produtos.id
ORDER BY pedidos.id, produtos.id;

-- EXERCÍCIO 4: agregações e GROUP BY
-- Para cada categoria de produto, mostre:
--
-- 1. categoria;
-- 2. quantidade de produtos, com o nome quantidade_produtos;
-- 3. preço médio, com o nome preco_medio.
--
-- Agrupe por categoria e ordene alfabeticamente por categoria.

SELECT
    produtos.categoria,
    COUNT(*) AS quantidade_produtos,
    AVG(produtos.preco) AS preco_medio
FROM produtos
GROUP BY produtos.categoria
ORDER BY produtos.categoria;

-- EXERCÍCIO 5: HAVING
-- Repita a consulta anterior abaixo, mas mantenha somente categorias com dois
-- ou mais produtos.
-- Use HAVING depois de GROUP BY e antes de ORDER BY.

SELECT
    produtos.categoria,
    COUNT(*) AS quantidade_produtos,
    AVG(produtos.preco) AS preco_medio
FROM produtos
GROUP BY produtos.categoria
HAVING COUNT(*) >= 2
ORDER BY produtos.categoria;

-- EXERCÍCIO 6: SUM por pedido
-- Para cada pedido, mostre:
--
-- 1. pedidos.id;
-- 2. clientes.nome;
-- 3. a soma de quantidade * preco_unitario, com o nome total_pedido.
--
-- Comece em pedidos, faça INNER JOIN com clientes e itens_pedido, agrupe por
-- pedidos.id e clientes.nome e ordene por pedidos.id.

SELECT
    pedidos.id,
    clientes.nome,
    SUM(
        itens_pedido.quantidade * itens_pedido.preco_unitario
    ) AS total_pedido
FROM pedidos
INNER JOIN clientes
    ON pedidos.cliente_id = clientes.id
INNER JOIN itens_pedido
    ON pedidos.id = itens_pedido.pedido_id
GROUP BY pedidos.id, clientes.nome
ORDER BY pedidos.id;

-- EXERCÍCIO 7: subconsulta simples
-- Liste nome e preço dos produtos cujo preço seja maior que a média de preço
-- de todos os produtos. Ordene pelo preço em ordem decrescente.
--
-- Use uma subconsulta com SELECT AVG(preco) FROM produtos dentro do WHERE.

SELECT nome, preco
FROM produtos
WHERE preco > (
    SELECT AVG(preco)
    FROM produtos
)
ORDER BY preco DESC;

-- EXERCÍCIO 8: UNION
-- Monte uma lista única com nomes de clientes e nomes de produtos.
--
-- A primeira consulta deve retornar:
-- clientes.nome com o nome item; texto fixo 'CLIENTE' com o nome tipo.
--
-- Una com uma segunda consulta que retorne:
-- produtos.nome; texto fixo 'PRODUTO'.
--
-- Use UNION e ordene o resultado final por item.
