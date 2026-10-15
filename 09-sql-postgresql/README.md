# PostgreSQL Practice

A self-contained module for learning SQL directly in PostgreSQL, without Spring Boot, JPA or Hibernate.

## Files

- `sql/01-estrutura.sql`: table creation, DDL and constraints
- `sql/02-dados.sql`: sample data, inserts, updates, deletes and basic queries
- `sql/03-consultas.sql`: joins, grouping, subqueries and UNION exercises
- `sql/03b-agregacoes-do-zero.sql`: independent review of aggregation
- `sql/04-transacoes.sql`: planned transactions practice
- `sql/05-views-e-permissoes.sql`: planned views and access-control practice
- `snapshots/`: small example database dump
- `PROGRESS.md`: actual progress and the recommended next exercise

## Running locally

The exercises assume a local PostgreSQL instance with a database named `estudos_sql`. SQL table/column names and exercise code remain in Portuguese for compatibility with the original learning database; the overview is in English.

```bash
psql -d estudos_sql
psql -d estudos_sql -v ON_ERROR_STOP=1 -f sql/01-estrutura.sql
```

These scripts are learning artifacts: read and run them in order and expect intentionally incomplete sections. The database dump and sample rows are for exercises only, never production data.
