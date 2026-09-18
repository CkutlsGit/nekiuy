# Nekiuy

Spring Java Core - Educational Application

## 📋 Overview

An educational **Spring Java Core** application with an **H2** database, built for learning purposes. It uses **logical views** - meaning it returns a template (view) instead of a response body (JSON).

The project consists of creating a regiment and adding people to it, then displaying that data.

## 🚀 Technology Stack

### Backend
- **Java 17+** - Core language
- **Spring Boot** - Application framework
- **Spring MVC** - Web layer with logical views
- **Spring Data JPA** - Database access and ORM

### Database
- **H2** - In-memory database for learning
  
## ✨ Features

- 🔐 **Regiment Management**
  - Create a regiment
  - Display the list of regiments

- 👤 **People Management**
  - Add a person to a regiment
  - Display people assigned to regiments

- ✅ **Logical Views**
  - Returns templates (views) instead of JSON responses
  - Redirects to the home page after form submissions

## 🛠️ Quick Start

### Prerequisites
- JDK 17+
- Maven 3.6+ (or Gradle)
- Git

### Installation & Running

1. **Clone the repository**
```bash
git clone https://github.com/CkutlsGit/nekiuy
cd nekiuy
```

2. **Build and run with Maven**
```bash
./mvnw spring-boot:run
```

On Windows:
```bash
mvnw.cmd spring-boot:run
```

Or, if `mvnw` is missing, use the system Maven:
```bash
mvn spring-boot:run
```

3. **Access the application**
```
http://localhost:8080/
```

## 📚 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Home page |
| POST | `/add/rgt` | Add a regiment and redirect to the home page |
| POST | `/add/people` | Add a person to a regiment and redirect to the home page |

## 📦 Project Structure

```
src/main/java/com/nekiuy/app/
├── controller/          # Spring MVC controllers
├── model/               # Domain models and entities
├── repository/          # JPA repositories
├── service/             # Business logic layer
└── AppApplication.java  # Application entry point

src/main/resources/
├── templates/           # View templates (Thymeleaf / JSP)
└── application.properties
```

Note: This project is intended for educational purposes.
