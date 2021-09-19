# Spring Boot Demo

This is a Spring Boot sandbox application used for testing and educational purposes.

This is a work in progress. The project is by no means a production application and should be
used for local testing only.

This service demonstrates basic CRUD operations in a
simple Spring Boot App built using Spring Initializer.

### Prerequisites

- JDK 11+
- Maven
- PostgreSQL Database

## Installing

### Student Database

Start a local instance of PostgreSQL.

```
docker run --rm -it -p 5432:5432 --name postgres -e POSTGRES_PASSWORD="test123" -e POSTGRES_USER="awaring" -e POSTGRES_DB=student -d postgres
```

## Scratches

```
GET http://localhost:8080/api/v1/student
```

```
POST http://localhost:8080/api/v1/student
Content-Type: application/json

{
  "name": "Link",
  "email": "link@nintendo.com",
  "dob": "1986-02-21"
}
```

```
DELETE http://localhost:8080/api/v1/student/delete/1
```

```
PUT http://localhost:8080/api/v1/student/update/1?name=Luigi&email=luigi@nintendo.com
```
