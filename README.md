# Spring Boot Demo

This is a Spring Boot sandbox application used primarily for testing and education.

This is a work in progress.

### Prerequisites

- JDK 11+
- Maven
- PostgreSQL Database

### Installing

## Student Database

Start a local instance of PostgreSQL.

```
Docker run -d -p 5432:5432 --name postgres -e POSTGRES_HOST_AUTH_METHOD=trust -e POSTGRES_DB=student postgres:latest
```