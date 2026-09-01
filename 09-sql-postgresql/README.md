# Treino de SQL com PostgreSQL

Projeto isolado para praticar SQL diretamente no PostgreSQL, sem Spring, JPA ou
Hibernate.

## Como vamos trabalhar

Os arquivos em `sql/` contêm enunciados, não soluções prontas. Escreva os
comandos pedidos, salve o arquivo e avise. Cada etapa será executada no banco e
o resultado será conferido antes da próxima.

## Ordem de hoje

1. `01-estrutura.sql` — SQL declarativa, DDL e restrições de integridade.
2. `02-dados.sql` — `INSERT`, `UPDATE`, `DELETE`, `SELECT`, `WHERE` e
   `ORDER BY`.
3. `03-consultas.sql` — junções, agregações, `GROUP BY`, `HAVING`, subconsulta
   e `UNION`.
4. `04-transacoes.sql` — `COMMIT`, `ROLLBACK`, `DROP`, `DELETE` e `TRUNCATE`.
5. `05-views-e-permissoes.sql` — views, `GRANT` e `REVOKE`.

O domínio será uma pequena loja, com clientes, produtos, pedidos e itens de
pedido. Isso permite enxergar chaves, relacionamentos e junções em dados
concretos.

## Conexão

O servidor local usa PostgreSQL 18, e o banco isolado se chama `estudos_sql`.

Na raiz deste projeto, abra o terminal interativo com:

```bash
psql -d estudos_sql
```

Para executar um arquivo inteiro e interromper no primeiro erro:

```bash
psql -d estudos_sql -v ON_ERROR_STOP=1 -f sql/01-estrutura.sql
```

Comandos úteis dentro do `psql`:

- `\dt` — listar tabelas;
- `\d clientes` — descrever a estrutura da tabela `clientes`;
- `\q` — sair.
