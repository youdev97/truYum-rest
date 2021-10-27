# truYum Spring Boot Rest Application

## Introduction

It's practice case study that I had to realize while following the Cognizant's FullStack Engineer Program.
Rest API for a Restaurant 'truYum' and where multiple use case specification must be provided like CRUD of Menu Items, Carts, etc.

## Architecture

If runnning in local H2(in-memmory database is used) if runned with docker -> 2 differents containers one with the Rest App and one having the MySQL DB

## Tools

* Java
* Maven
* Spring Boot
* H2
* MySQL
* Swagger
* Docker


## Run

In the root folder :

With docker (MySQL)

```console
mvn package
docker-compose up
```

Without docker (H2)

```console
mvn package
java -jar target/truYum3-0.0.1-SNAPSHOT.jar
```

Swagger available at
<http://localhost:8080/swagger-ui.html>
