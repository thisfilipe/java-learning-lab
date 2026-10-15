# PostgreSQL Practice

A standalone collection of exercises for learning SQL directly in PostgreSQL, without Spring Boot, JPA, Hibernate or H2.

## Contents

- `sql/01-structure.sql`: DDL, table creation and constraints
- `sql/02-data.sql`: inserts, updates, deletes and basic queries
- `sql/03-queries.sql`: joins, aggregations, subqueries and a deliberately unfinished UNION exercise
- `sql/03b-aggregations-from-scratch.sql`: independent reconstruction of aggregation queries
- `sql/04-transactions.sql`: planned transactions and data removal practice
- `sql/05-views-and-permissions.sql`: planned views and permissions practice
- `snapshots/learning_sql-2026-08-31.sql`: example database snapshot with translated identifiers
- `PROGRESS.md`: learning progress and what to practice next

## Set up a fresh practice database

The original local exercises used Portuguese SQL identifiers. These scripts now use English identifiers (`customers`, `products`, `orders`, `order_items`). **They will not work unchanged with the original Portuguese-schema database.** A new dedicated database is the simplest approach.

```bash
createdb java_learning_sql
psql -d java_learning_sql -v ON_ERROR_STOP=1 -f sql/01-structure.sql
psql -d java_learning_sql -v ON_ERROR_STOP=1 -f sql/02-data.sql
psql -d java_learning_sql -f sql/03-queries.sql
```

Alternatively, restore the translated example snapshot into an *empty* dedicated database:

```bash
createdb java_learning_snapshot
psql -d java_learning_snapshot -v ON_ERROR_STOP=1 -f snapshots/learning_sql-2026-08-31.sql
```

Do not run both setup approaches on the same database. Some exercise files intentionally contain unfinished sections. The sample data is fictional and is not production data.
