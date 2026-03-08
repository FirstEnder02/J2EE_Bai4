# J2EE_Bai4 - Spring Boot Product Management App

## Overview
A Spring Boot web application for basic Product Management (CRUD operations). Built as a Java EE laboratory exercise, it allows users to view, create, and edit products with image uploads.

## Tech Stack
- **Language:** Java 17 (compiled, runs on GraalVM CE 22.3.1 / Java 19 runtime)
- **Framework:** Spring Boot 4.0.3
- **Template Engine:** Thymeleaf
- **Build System:** Apache Maven (via `mvnw` wrapper)
- **Validation:** Jakarta Validation + Hibernate Validator
- **Utilities:** Lombok

## Project Structure
- `src/main/java/J2EE_Bai4/` - Main Java source
  - `Application.java` - Spring Boot entry point
  - `controllers/` - HTTP request handlers (HomeController, ProductController)
  - `models/` - Data models (Product, Category)
  - `service/` - Business logic with in-memory storage (ProductService, CategoryService)
- `src/main/resources/` - Application resources
  - `templates/` - Thymeleaf HTML templates
  - `application.properties` - App configuration

## Configuration
- **Port:** 5000 (configured in `application.properties`)
- **Host:** 0.0.0.0 (binds to all interfaces)
- **Storage:** In-memory (ArrayList) - data is lost on restart

## Running the App
```bash
./mvnw spring-boot:run
```

## Key Notes
- The `mvnw` script requires execute permissions (`chmod +x mvnw`)
- Java version in `pom.xml` set to 17 to match the GraalVM 22.3.1 runtime (which supports up to Java 19)
- Test dependencies fixed: replaced non-existent `spring-boot-starter-*-test` artifacts with `spring-boot-starter-test`
