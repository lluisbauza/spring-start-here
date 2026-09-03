# spring-start-here
Personal learning repository based on the book *Spring Start Here* by Laurentiu Spilca.

This repository contains a collection of small, independent projects created to practise and consolidate Spring, Spring Core and Spring Boot concepts through progressive activities.

As the repository progresses, the projects move from core Spring concepts such as dependency injection and bean management towards web applications, REST APIs, persistence, transactions and testing.

## Technologies
- Java
- Spring Framework
- Spring Boot
- Maven
- Spring MVC
- Thymeleaf
- JDBC
- Spring Data JPA
- JUnit 5
- Mockito

## Topics covered
- Spring IoC container and dependency injection
- Bean configuration, scopes and lifecycle
- Component scanning and bean selection
- Spring AOP
- Spring MVC and Thymeleaf
- REST API design
- Request parameters, path variables and HTTP responses
- DTOs and exception handling
- Consuming external REST APIs
- JDBC and relational database access
- Transactions
- Spring Data JPA
- Repository and service layers
- JUnit 5 and Mockito testing

## Repository structure

Each activity is an independent Maven project with its own `pom.xml`, source code and configuration.

```text
spring-start-here/
├── activity-01-car-rental/
├── activity-02-plant-care/
├── activity-03-incident-management/
├── activity-04-technician-dashboard/
├── activity-05-dynamic-employee-profile/
├── activity-06-incident-board/
├── activity-07-agent-rating-tracker/
├── activity-08-product-catalog/
├── activity-09-library-lending/
├── activity-10-pokeapi-client/
├── activity-11-movie-ticket-sale/
├── activity-12-stock-transfer/
├── activity-13-cinema-seat-manager/
└── README.md
```

## Activities

### 01 — Car Rental

A small car rental application focused on the fundamentals of the Spring application context and dependency management.

**Main concepts:** Spring IoC container, `ApplicationContext`, `@Configuration`, `@Bean`, `@Component`, component scanning and dependency injection.

Directory: `activity-01-car-rental`

---

### 02 — Plant Care

A plant moisture analysis application that selects and injects different sensor implementations depending on the required behaviour.

**Main concepts:** constructor injection, programming against interfaces, multiple bean implementations, `@Qualifier`, `@Component`, `@Service` and bean selection.

Directory: `activity-02-plant-care`

---

### 03 — Incident Management

A technical support incident management application used to practise more advanced bean management and cross-cutting concerns.

**Main concepts:** singleton and prototype scopes, `ObjectProvider`, lazy and eager initialization, `@Primary`, `@Qualifier`, custom exceptions, Spring AOP, custom annotations, `@Aspect`, `@Before` and `@Around`.

Directory: `activity-03-incident-management`

---

### 04 — Technician Dashboard

A simple web application that introduces Spring Boot web development and the structure of an MVC application.

**Main concepts:** Spring Boot, Spring MVC, controllers, request mappings, model attributes, HTML views and basic web application structure.

Directory: `activity-04-technician-dashboard`

---

### 05 — Dynamic Employee Profile

A web application focused on handling dynamic data received through HTTP requests and displaying it through server-rendered views.

**Main concepts:** request parameters, path variables, controller mappings, dynamic routes, model data and Spring MVC request handling.

Directory: `activity-05-dynamic-employee-profile`

---

### 06 — Incident Board

An incident management web interface that displays, filters and retrieves incident information through Thymeleaf views.

**Main concepts:** Spring MVC, Thymeleaf, controllers, service layer separation, dynamic views, filtering, path variables and error handling.

Directory: `activity-06-incident-board`

---

### 07 — Agent Rating Tracker

A web application used to practise HTTP interactions and the handling of application data through Spring controllers.

**Main concepts:** Spring MVC, HTTP requests, controller-service separation, form/request data handling and application-layer organisation.

Directory: `activity-07-agent-rating-tracker`

---

### 08 — Product Catalog

A REST API for managing a product catalogue, introducing REST-style controllers and HTTP-based communication.

**Main concepts:** REST APIs, `@RestController`, HTTP methods, request bodies, path variables, DTOs, HTTP status codes, `ResponseEntity`, service-layer responsibilities and global exception handling.

Directory: `activity-08-product-catalog`

---

### 09 — Library Lending

A REST API for managing books and lending operations while practising more complete HTTP request and response handling.

**Main concepts:** REST controllers, DTOs, path variables, request bodies, response headers, `ResponseEntity`, controller-service separation and exception handling.

Directory: `activity-09-library-lending`

---

### 10 — PokeAPI Client

A Spring Boot application that consumes the external PokéAPI and exposes selected data through its own REST endpoints.

**Main concepts:** consuming REST APIs, `RestClient`, JSON mapping, DTO records, query parameters, error handling, external API integration and reusable HTTP client configuration.

Directory: `activity-10-pokeapi-client`

---

### 11 — Movie Ticket Sale

A ticket sales application backed by a relational database and implemented using Spring JDBC.

**Main concepts:** `JdbcTemplate`, SQL queries, datasource configuration, repositories, `RowMapper`, lambda-based row mapping, service-layer logic and relational database access.

Directory: `activity-11-movie-ticket-sale`

---

### 12 — Stock Transfer

A warehouse stock transfer application designed to practise transactional operations involving multiple database updates.

**Main concepts:** `@Transactional`, transaction boundaries, commit and rollback behaviour, JDBC repositories, business validations, custom exceptions and transactional service methods.

Directory: `activity-12-stock-transfer`

---

### 13 — Cinema Seat Manager

A REST API for managing cinema seats, reservations and prices using Spring Data JPA instead of manually implemented database access.

**Main concepts:** JPA entities, `JpaRepository`, derived query methods, Spring Data repositories, persistence, DTOs, service-layer validation, REST endpoints, custom exceptions, JUnit 5 and Mockito.

Directory: `activity-13-cinema-seat-manager`

## Status
Completed.

## Author
Lluís Bauzá
