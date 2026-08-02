# spring-start-here
Personal learning repository based on the book *Spring Start Here* by Laurentiu Spilca.

This repository contains a collection of small, independent projects created to practise and consolidate Spring, Spring Core and Spring Boot concepts through progressive activities.

The main goal is not only to follow the examples from the book, but to apply each concept in small use cases developed from scratch.


## Technologies
- Java 25
- Spring Framework 6
- Maven
- IntelliJ IDEA


## Repository structure
Each activity is an independent Maven project with its own `pom.xml` and source code.

```text
spring-start-here/
├── activity-01-car-rental-context/
├── activity-02-plant-care/
├── activity-03-incident-management/
└── README.md
```

## Activities

### Activity 01: Car Rental Context
A small car rental application focused on the fundamentals of the Spring context.

Main concepts practised:
- Spring application context
- Bean creation
- `@Configuration`
- `@Bean`
- `@Component`
- Component scanning
- Dependency injection
- Basic bean wiring

Directory: `activity-01-car-rental-context`

---

### Activity 02: Plant Care
A plant moisture analysis application that selects and injects different sensor implementations.

Main concepts practised:
- Dependency injection through constructors
- Programming against interfaces
- Multiple bean implementations
- `@Qualifier`
- `@Component`
- `@Service`
- Component scanning
- Bean selection and wiring

Directory: `activity-02-plant-care`

---

### Activity 03: Incident Management
A technical support incident management application that creates incidents, assigns technicians, sends notifications and generates reports.

Main concepts practised:
- Singleton and prototype bean scopes
- `ObjectProvider`
- Lazy and eager bean initialization
- `@Primary`
- `@Qualifier`
- Injection of bean collections
- Factory pattern
- In-memory repository
- Custom exceptions
- Spring AOP
- Custom annotations
- `@Aspect`
- `@Before`
- `@Around`
- Method execution time measurement

Directory: `activity-03-incident-management`


## Running an activity
Each activity must be opened or executed as an independent Maven project.
1. Open the selected activity directory in IntelliJ IDEA.
2. Allow Maven to download and configure its dependencies.
3. Run its main class.

Alternatively, from the selected activity directory:

```bash
mvn clean compile
```

## Learning approach
The activities are intentionally small and console-based so that each project can focus on a limited group of Spring concepts without introducing databases, web APIs or user interfaces too early.

The repository will continue to grow as new Spring and Spring Boot topics are studied.

## Author
Lluís Bauzá
