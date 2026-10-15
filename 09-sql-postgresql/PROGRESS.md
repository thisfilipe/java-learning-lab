# SQL Learning Progress

## Context

This module contains direct PostgreSQL practice, independent from Spring Boot, JPA, Hibernate and H2. The exercises now use English table/column names. The original local database named `estudos_sql` still has Portuguese identifiers and must be migrated or replaced with a separate practice database to run the translated scripts.

## Completed practice

- DDL, `CREATE TABLE`, `ALTER TABLE` and integrity constraints: primary/foreign keys, `NOT NULL`, `UNIQUE`, `DEFAULT`, `CHECK`.
- DML: `INSERT`, `UPDATE`, `DELETE`.
- Queries with `SELECT`, `WHERE`, `IS NULL`, `ORDER BY`.
- Initial practice with inner/left joins and a subquery, but these need independent review.
- Aggregations were rebuilt from scratch on September 2, 2026, in `sql/03b-aggregations-from-scratch.sql`: `SUM`, `COUNT(*)` vs `COUNT(column)`, `AVG`, `GROUP BY`, `HAVING`, and filters before/after grouping.

During the aggregation recap, a new query was written without a scaffold, combining `WHERE estoque >= 10`, `SUM(preco)`, `GROUP BY categoria`, `HAVING SUM(preco) > 200` and ordering by the aggregate. The predicted output was verified against PostgreSQL. This is evidence of understanding at that point, not a claim of permanent mastery.

## Resume here

1. Rebuild `JOIN` independently, starting with two small tables, predicting matching rows and writing the query without a near-complete scaffold.
2. Rebuild `UNION`.
3. Rebuild subqueries.
4. Compare `DROP`, `DELETE` and `TRUNCATE`; practice `COMMIT` and `ROLLBACK`.
5. Practice views and `GRANT`/`REVOKE`.

Prefer exercises with concrete inputs, predictions, execution and an explanation of results. Do not count guided answers from previous sessions as mastery.

## Example database snapshot

`snapshots/learning_sql-2026-08-31.sql` preserves the sample schema and data. The names and addresses in it are fictional examples.
