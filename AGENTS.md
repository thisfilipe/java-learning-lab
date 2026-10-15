# Java Learning Lab - Agent Instructions

## Purpose

Help me learn Java and backend development for professional use. This is a personal learning workspace, not a production product. Prioritize conceptual understanding and practical backend engineering.

The goal is to understand how things work, write the code myself, and build confidence through experiments, debugging, and progressively harder exercises. Do not silently implement exercises on my behalf.

## How I learn

- Prefer concrete, runnable examples and observations over abstract lectures.
- Introduce one unfamiliar concept at a time. Don't pile up interfaces, generics, overloading, and polymorphism in a single initial example.
- Let me predict what code will do, write my own version, execute it, explain the result, and fix mistakes.
- Ask leading questions only when they make sense. Do not hand out a complete solution or near-complete scaffolding before I've tried.
- When I struggle, simplify the example and consolidate rather than advancing the syllabus.
- Distinguish concepts I have genuinely demonstrated from code that only ran after guided corrections.
- If I need a recap, compare contrasting code examples and show observable runtime behavior.
- I have previously worked with JavaScript/Node and n8n; use that experience for analogies when useful, but don't assume advanced mastery.
- Point out actual bugs and incorrect reasoning clearly. Maintain a supportive but technically precise tone.

## Project structure

Folders are ordered roughly by learning sequence.

- `01-hello-world`: basic Java entry point and output
- `02-variables`: types, variables, strings
- `03-control-flow`: conditionals, loops, modern switch
- `04-oop`: classes, inheritance, arrays, lists, maps
- `05-interfaces`: contracts and polymorphism (worth revisiting)
- `06-maven-basics`: Maven structure, build lifecycle, JUnit tests
- `07-review`: independent exercises revisiting previous concepts
- `08-spring-boot-from-scratch`: task/category CRUD with Spring MVC, JPA/Hibernate, H2, JUnit, MockMvc
- `09-sql-postgresql`: direct SQL practice without Spring or Hibernate

## Current technical context

- Java 21, Maven/Maven Wrapper, JUnit 5.
- Spring Boot task API has a controller/service/repository structure, task/category entities with a one-to-many relationship, and an in-memory H2 database.
- PostgreSQL SQL training uses a separate dedicated practice database (`java_learning_sql`). The SQL identifiers were translated into English. Older local databases containing the Portuguese schema must be migrated or rebuilt before executing the new scripts.
- Do not assume the development environment is still Windows/WSL. Inspect the current environment before giving platform-specific commands.
- For the Spring Boot example, run `cd 08-spring-boot-from-scratch && ./mvnw test` when changing its code. GitHub Actions also runs this module's tests.

## What has already been practiced

- Java syntax, primitive types, control flow, arrays, constructors, classes, access modifiers, inheritance, lists and maps.
- Maven project layout and lifecycle, JUnit basics, and Java package/classpath basics.
- Spring Boot application startup, dependency injection, controllers, HTTP verbs/statuses, request mapping, JSON, and integration testing.
- Spring Data JPA repositories and persistence with H2, task/category relationships, `@Entity`, `@Id`, `@GeneratedValue`, `@OneToMany`, `@ManyToOne`, and `@JoinColumn`.
- Observed JPA lifecycle operations (`persist`, `flush`, `clear`, `find`) and dirty checking. This is not the same as full conceptual mastery.
- PostgreSQL DDL, constraints, DML, `SELECT`/`WHERE`/`ORDER BY`, and aggregation (`SUM`, `COUNT`, `AVG`, `GROUP BY`, `HAVING`).

## Areas to consolidate

- Interface design and polymorphism in practical settings.
- JPA/Hibernate entity states, transactions, cascading, lazy/eager fetching, and relationships beyond the basic CRUD that currently works.
- SQL JOIN, UNION, and subqueries by independently reconstructing each from concrete table rows, not by rerunning previously completed answers.
- Later SQL work: `DROP` vs `DELETE` vs `TRUNCATE`, transactions, views, `GRANT`, and `REVOKE`.
- Further backend topics should be chosen for their professional value and after checking the current learning goals.

## Resuming SQL practice

See [09-sql-postgresql/PROGRESS.md](09-sql-postgresql/PROGRESS.md). Start by revisiting JOIN from scratch using two small sets of rows: predict matches, write the query independently, execute, then explain. Continue with UNION and subqueries. The aggregations exercise was already reconstructed independently and need not be repeated without reason.

## Working style

- Preserve functioning code when changing naming or structure. Explain any intentional breaks to local setups.
- Never confuse an assistant-written solution with evidence that I've learned the concept.
- Favor small, testable, reversible steps and meaningful commit messages.
- Treat this as a learning archive: small exercises, intermediate attempts, and explicitly unfinished work are legitimate content.
