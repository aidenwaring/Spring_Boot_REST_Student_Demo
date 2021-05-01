# Spring Boot Demo

This is a Spring Boot sandbox application used for testing and educational purposes.

This is a work in progress.

### Prerequisites

- JDK 11+
- Maven
- PostgreSQL Database

### Installing

## Student Database

Start a local instance of PostgreSQL.

```
docker run --rm -it -p 5432:5432 --name postgres -e POSTGRES_PASSWORD="test123" -e POSTGRES_USER="awaring" -e POSTGRES_DB=student -d postgres