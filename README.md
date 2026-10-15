# Java Learning Lab

A hands-on, chronological record of my Java backend learning. These are **learning exercises**, not production-ready applications. I keep the progression visible, including experiments, small mistakes, revisions, tests, and concepts that still need practice.

## What's inside

| Module | Topics |
| --- | --- |
| [01 - Hello World](01-hello-world/) | Compiling and running a first Java program |
| [02 - Variables](02-variables/) | Primitive types, strings, and output |
| [03 - Control flow](03-control-flow/) | Conditions, loops, switch expressions |
| [04 - OOP](04-oop/) | Classes, inheritance, collections, maps |
| [05 - Interfaces](05-interfaces/) | Interfaces and polymorphism |
| [06 - Maven basics](06-maven-basics/) | Maven project structure and JUnit |
| [07 - Review](07-review/) | Independent practice and revision |
| [08 - Spring Boot from scratch](08-spring-boot-from-scratch/) | REST API, Spring MVC, Spring Data JPA, Hibernate, H2, integration tests |
| [09 - PostgreSQL](09-sql-postgresql/) | SQL, constraints, joins, grouping, queries, and transactions (work in progress) |

### Featured exercise: Spring Boot task API

The most substantial module is [08 - Spring Boot from scratch](08-spring-boot-from-scratch/). It implements a small task/category REST API with controller, service, and repository layers; JPA relationships; an in-memory H2 database; and automated tests.

Run its tests with JDK 21 installed:

```bash
cd 08-spring-boot-from-scratch
./mvnw test
```

Run the API locally:

```bash
./mvnw spring-boot:run
```

The database is in memory, so stored data is not persisted across restarts. This API has no authentication, and it is meant for local study only.

### SQL practice

The [PostgreSQL module](09-sql-postgresql/README.md) is separate from the Spring Boot app. Its SQL scripts and example data document hands-on database practice. The exercises and snapshot now use English SQL identifiers. Older local practice databases using Portuguese table names need to be recreated or migrated before running the updated scripts.

## Notes

- The earliest modules consist of standalone `.java` files. Compile and run each module separately; they are not one Maven project. The Java class names and learning examples have been translated to English.
- Module 06 uses Maven and JUnit; module 08 uses Spring Boot and Maven Wrapper.
- The [GitHub Actions workflow](.github/workflows/tests.yml) compiles the standalone exercises and runs Maven, Spring Boot and PostgreSQL checks on push.
- Some lessons are unfinished on purpose. This repository is a learning log, not a polished framework or reusable library.
- [AGENTS.md](AGENTS.md) contains the learning preferences and context used by coding assistants.

## License

This repository is released under the [MIT License](LICENSE).
