# CRUD Demo Student App

A simple Spring Boot application demonstrating Hibernate / JPA CRUD operations for a `Student` entity.

## Overview

This project is a basic Spring Boot CRUD demo using:

- Spring Boot 4.0.5
- Spring Data JPA
- MySQL Connector/J
- Java 17

The app includes a `Student` entity and a DAO implementation for create, read, update, and delete operations.

## Project Structure

- `src/main/java/com/luv2code/cruddemo/`
  - `CruddemoApplication.java` - main Spring Boot application class
  - `dao/StudentDAO.java` - DAO interface for student operations
  - `dao/StudentDAOImpl.java` - DAO implementation using JPA
  - `entity/Student.java` - JPA entity class for student records
- `src/main/resources/application.properties` - application configuration

## Prerequisites

- Java 17
- Maven
- MySQL database (or compatible JDBC datasource)

## Running the Application

1. Configure the database connection in `src/main/resources/application.properties`.
2. From the project root, run:

```bash
./mvnw spring-boot:run
```

On Windows, run:

```powershell
mvnw.cmd spring-boot:run
```

## Building the Project

Use Maven to build the app:

```bash
./mvnw clean package
```

On Windows:

```powershell
mvnw.cmd clean package
```

## Notes

- Update `application.properties` with your MySQL URL, username, and password.
- This project is designed as a learning example for Spring Boot + JPA CRUD.
