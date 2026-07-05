# Job Portal Backend

A secure REST API for a full-stack Job Portal built with Java and the Spring ecosystem.

This project represents my progression from understanding database connectivity with JDBC to building a complete secured backend using Spring Boot, Hibernate, Spring Data JPA, Spring Security, and MySQL.

## Related Repository

Frontend Repository:

https://github.com/Randomlyclueless/job-portal-frontend

The React frontend consumes the REST APIs provided by this backend.

## Tech Stack

**Language:** Java

**Framework:** Spring Boot

**Security:** Spring Security, BCrypt

**Persistence:** Spring Data JPA, Hibernate

**Database:** MySQL

**AOP:** Spring AOP

**Build Tool:** Maven

**Containerization:** Docker

## Features

- User registration
- Secure password hashing using BCrypt
- HTTP Basic Authentication
- Public job browsing
- Search jobs by keyword
- Create job posts
- Update existing job posts
- Delete job posts
- Protected write operations
- MySQL persistence
- RESTful API architecture
- CORS configuration
- Centralized security configuration
- AOP-based method logging
- Exception execution logging
- Performance monitoring
- Input validation

## Architecture

```text
React Frontend
       |
       | Axios / HTTP
       v
Spring Security
       |
       v
REST Controllers
       |
       v
Service Layer
       |
       +-------- Spring AOP
       |
       v
Spring Data JPA
       |
       v
Hibernate ORM
       |
       v
MySQL Database
```

## Authentication Flow

```text
User enters username and password
              |
              v
React Frontend
              |
              | HTTP Basic Authentication
              v
Spring Security Filter Chain
              |
              v
DaoAuthenticationProvider
              |
              v
MyUserDetailsService
              |
              v
UserRepository
              |
              v
MySQL users table
              |
              v
BCrypt password verification
              |
              v
Request Authorized / Rejected
```

Passwords are never stored as plain text.

Before persistence, passwords are encoded using BCrypt with a strength of 12.

## API Endpoints

| Method | Endpoint | Description | Access |
| --- | --- | --- | --- |
| POST | `/register` | Register a new user | Public |
| GET | `/jobPosts` | Fetch all job posts | Public |
| GET | `/jobPost/{postId}` | Fetch a job by ID | Public |
| GET | `/jobPosts/keyword/{keyword}` | Search jobs by keyword | Public |
| POST | `/jobPost` | Create a job post | Authenticated |
| PUT | `/jobPost` | Update a job post | Authenticated |
| DELETE | `/jobPost/{postId}` | Delete a job post | Authenticated |

## Database Design

The application uses MySQL with Spring Data JPA and Hibernate.

Main entities:

```text
User
├── id
├── username
└── password

JobPost
├── postId
├── postProfile
├── postDesc
├── reqExperience
└── postTechStack
```

Job technology stacks are persisted using a related collection table managed through Hibernate.

## Spring Security

The backend uses stateless HTTP Basic Authentication.

Public endpoints allow users to browse and search jobs.

Create, update, and delete operations require authenticated credentials.

The authentication provider uses:

```text
DaoAuthenticationProvider
        |
        v
UserDetailsService
        |
        v
BCryptPasswordEncoder
```

## Spring AOP

Spring AOP is used to separate cross-cutting concerns from the business logic.

The project contains aspects for:

- Logging method calls
- Logging successful executions
- Logging execution failures
- Measuring service execution time
- Validating method arguments

This helped me understand how aspects intercept service-layer methods using pointcut expressions and advice annotations.

## Project Structure

```text
src/main/java/spring_boot_rest/spring_boot_rest
|
├── aop
│   ├── LoggingAspect.java
│   ├── PerformanceMonitoringAspect.java
│   └── ValidationAspect.java
|
├── config
│   └── SecurityConfig.java
|
├── controller
│   └── JobRestController.java
|
├── model
│   ├── JobPost.java
│   ├── User.java
│   └── UserPrincipal.java
|
├── repository
│   ├── JobRepo.java
│   └── UserRepo.java
|
└── service
    ├── JobService.java
    ├── MyUserDetailsService.java
    └── UserService.java
```

## Running Locally

### 1. Clone the backend

```bash
git clone BACKEND_REPO_URL
```

### 2. Navigate to the project

```bash
cd spring-boot-rest
```

### 3. Configure MySQL

Update:

```text
src/main/resources/application.properties
```

Configure your datasource URL, username, and password.

### 4. Run the backend

Windows:

```bash
mvnw.cmd spring-boot:run
```

The API starts at:

```text
http://localhost:8080
```

### 5. Run the frontend

Follow the setup instructions in the frontend repository:

https://github.com/Randomlyclueless/job-portal-frontend

## Current Deployment Work

The application is currently being prepared for deployment.

Planned deployment architecture:

```text
React Frontend
      |
      v
Frontend Hosting
      |
      v
Dockerized Spring Boot API
      |
      v
Cloud MySQL Database
```

The Spring Boot backend is currently being containerized using Docker.

## Learning Journey

This project was built while progressing through:

```text
JDBC
  ↓
Hibernate
  ↓
Spring Boot
  ↓
REST APIs
  ↓
Spring Security
  ↓
React Integration
  ↓
Docker & Deployment
```

Rather than building isolated examples for each technology, I used this project to understand how the complete Java backend ecosystem connects in a full-stack application.

## Frontend

The React frontend for this application is available here:

https://github.com/Randomlyclueless/job-portal-frontend

## Status

Core application functionality is complete.

Deployment and containerization are currently in progress.
