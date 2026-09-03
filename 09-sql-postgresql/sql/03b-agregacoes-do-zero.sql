-- RECONSTRUÇÃO DAS AGREGAÇÕES
--
-- Não consulte as respostas antigas de 03-consultas.sql durante estes
-- exercícios. A meta aqui é compreender o resultado, não reproduzir sintaxe.

-- EXERCÍCIO 1: SUM sem GROUP BY
--
-- A tabela produtos contém estes preços:
-- 250.00, 120.00, 900.00 e 150.00.
--
-- 1. Antes da consulta, escreva em um comentário qual resultado você espera.
-- 2. Escreva uma consulta que some a coluna preco de todas as linhas da tabela
--    produtos.
-- 3. Dê à coluna resultante o nome total_precos.

/* vai retornar uma coluna chamada total_precos com os precos somados, 1420.00 */

SELECT SUM(preco) AS total_precos
FROM produtos;

-- EXERCÍCIO 2: WHERE antes de SUM
--
-- Some somente os preços dos produtos da categoria 'Periféricos'.
-- Dê à coluna resultante o nome total_perifericos.
--
-- Antes da consulta, escreva em um comentário:
-- 1. quais preços passarão pelo WHERE;
-- 2. qual total você espera.

/* só os preços das linhas que têm categoria Periféricos, totalizando 370.00 */

SELECT SUM(preco) AS total_perifericos
FROM produtos
WHERE categoria = 'Periféricos';

-- EXERCÍCIO 3: COUNT sem GROUP BY
--
-- Conte quantos produtos pertencem à categoria 'Periféricos'.
-- Dê à coluna resultante o nome quantidade_perifericos.
--
-- Antes da consulta, escreva em um comentário:
-- 1. quais linhas passarão pelo WHERE;
-- 2. qual número você espera que COUNT devolva.

/* só duas linhas vão passar, as que têm a categoria exigida, então vai devolver 2 */

SELECT COUNT(*) AS quantidade_perifericos
FROM produtos
WHERE categoria = 'Periféricos';

-- EXERCÍCIO 4: COUNT(*) versus COUNT(coluna)
--
-- Na tabela clientes existem 3 linhas, mas apenas Bruno possui telefone; Ana e
-- Carla têm telefone NULL.
--
-- Escreva uma única consulta que retorne:
-- 1. COUNT(*) com o nome total_clientes;
-- 2. COUNT(telefone) com o nome clientes_com_telefone.
--
-- Antes da consulta, escreva em comentário os dois resultados esperados.

/* o primeiro vai retornar 3, que é todos os clientes, o segundo vai retornar 1, porque só um cliente tem telefone */

SELECT
    COUNT(*) AS total_clientes,
    COUNT(telefone) AS clientes_com_telefone
FROM clientes;

-- EXERCÍCIO 5: AVG sem GROUP BY
--
-- Calcule a média dos preços de todos os produtos.
-- Dê à coluna resultante o nome media_precos.
--
-- Antes da consulta, escreva em comentário:
-- 1. a soma dos quatro preços;
-- 2. a quantidade de preços;
-- 3. a divisão usada para prever a média.

/* 1420.00 (total) / 4 (quantidade) */

SELECT AVG(preco) AS media_precos
FROM produtos;

-- EXERCÍCIO 6: GROUP BY com AVG
--
-- Mostre uma linha para cada categoria contendo:
-- 1. o nome da categoria;
-- 2. a média dos preços daquele grupo, com o nome media_preco.
--
-- Agrupe as linhas pela coluna categoria.
-- Não use WHERE, HAVING ou ORDER BY neste exercício.
--
-- Antes da consulta, registre em comentário quantas linhas você espera e as
-- três médias previstas.

/* 3 linhas, 185, 900 e 150 */

SELECT categoria, AVG(preco) AS media_preco
FROM produtos
GROUP BY categoria;

-- EXERCÍCIO 7: várias agregações por grupo
--
-- Para cada categoria, mostre:
-- 1. categoria;
-- 2. COUNT(*) com o nome quantidade_produtos;
-- 3. SUM(preco) com o nome total_precos.
--
-- Use GROUP BY categoria. Não use WHERE, HAVING ou ORDER BY.
-- Antes da consulta, registre em comentário a quantidade e a soma esperadas
-- para cada uma das três categorias.

/* 
Periféricos → quantidade 2 | soma 370.00
Monitores   → quantidade 1 | soma 900.00
Acessórios  → quantidade 1 | soma 150.00
*/

SELECT 
    categoria,
    COUNT(*) AS quantidade_produtos,
    SUM(preco) AS total_precos
FROM produtos
GROUP BY categoria;

-- EXERCÍCIO 8: HAVING
--
-- Repita a consulta anterior, mas exiba somente categorias que tenham mais de
-- um produto.
--
-- Use HAVING com COUNT(*) depois de GROUP BY.
-- Não use WHERE neste exercício.
-- Antes da consulta, registre em comentário qual grupo deverá permanecer e
-- por que os outros dois serão removidos.

/*
só vai retornar Periféricos, que tem 2 itens, portanto vai retornar:

| categoria | quantidade_produtos | total_precos |
| Periféricos | 2 | 370.00 |
*/

SELECT 
    categoria,
    COUNT(*) AS quantidade_produtos,
    SUM(preco) AS total_precos
FROM produtos
GROUP BY categoria
HAVING COUNT(*) > 1;

-- EXERCÍCIO 9: WHERE e HAVING na mesma consulta
--
-- Considere somente produtos com preco menor que 500.
-- Depois agrupe por categoria e mostre somente grupos com mais de um produto.
--
-- Exiba categoria e COUNT(*) com o nome quantidade_produtos.
--
-- Antes da consulta, registre em comentário:
-- 1. quais produtos sobrevivem ao WHERE;
-- 2. quais grupos são formados;
-- 3. qual grupo sobrevive ao HAVING.

/* só um produto não sobrevive ao WHERE, que é o de 900.00;
vão ser formados apenas os grupos Periféricos e Acessórios;
só Periféricos vai sobreviver ao HAVING */

SELECT categoria, COUNT(*) AS quantidade_produtos
FROM produtos
WHERE preco < 500
GROUP BY categoria
HAVING COUNT(*) > 1;

-- EXERCÍCIO 10: transferência sem esqueleto
--
-- Produza um relatório que:
--
-- 1. considere somente produtos com estoque de pelo menos 10 unidades;
-- 2. calcule a soma dos preços por categoria;
-- 3. mostre somente categorias cuja soma seja maior que 200;
-- 4. exiba categoria e a soma com o nome total_categoria;
-- 5. ordene da maior para a menor soma.
--
-- Antes da consulta, descreva em comentário as linhas que passam pelo primeiro
-- filtro, os grupos formados e o resultado final esperado.
-- Escreva a consulta sem consultar os exercícios anteriores.

/* só vão passar os produtos com 10 ou mais itens no estoque (todos menos o monitor),
depois, formam-se grupos das categorias que têm tais itens (Periféricos, Acessórios),
e somam-se os valores de cada grupo, passando só Periféricos pelo HAVING;
por fim, retorna as colunas categoria e total_categoria, contendo, respectivamente
Periféricos e 370.00  */

SELECT categoria, SUM(preco) AS total_categoria
FROM produtos
WHERE estoque >= 10
GROUP BY categoria
HAVING SUM(preco) > 200
ORDER BY total_categoria DESC;
