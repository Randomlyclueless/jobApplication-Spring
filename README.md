# Job Portal Backend

A secure RESTful backend for a full-stack Job Portal application built using Java and the Spring ecosystem.

This project was developed while progressing through JDBC, Hibernate, Spring Boot, REST APIs, and Spring Security, with the goal of understanding how Java backend technologies work together in a real application.

## Tech Stack

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- Spring AOP
- MySQL
- Maven
- Docker

## Features

- User registration
- User authentication
- BCrypt password hashing
- HTTP Basic Authentication
- Job CRUD operations
- Search jobs by keyword
- Public job viewing
- Protected create, update, and delete operations
- MySQL database integration
- CORS configuration
- REST API architecture
- AOP-based logging
- Performance monitoring
- Input validation

## REST API Endpoints

| Method | Endpoint | Description | Access |
| --- | --- | --- | --- |
| POST | `/register` | Register a new user | Public |
| GET | `/jobPosts` | Get all job posts | Public |
| GET | `/jobPost/{postId}` | Get job by ID | Public |
| GET | `/jobPosts/keyword/{keyword}` | Search jobs | Public |
| POST | `/jobPost` | Create a job post | Authenticated |
| PUT | `/jobPost` | Update a job post | Authenticated |
| DELETE | `/jobPost/{postId}` | Delete a job post | Authenticated |

## Security

The application uses Spring Security with HTTP Basic Authentication.

User passwords are hashed using BCrypt before being stored in the database.

Public users can view and search job posts, while authenticated users can create, update, and delete job posts.

## Spring AOP

Spring AOP is used for cross-cutting concerns including:

- Method call logging
- Method execution logging
- Exception logging
- Performance monitoring
- Input validation

## Application Architecture

```text
React Frontend
       |
       | REST API
       v
Spring Boot Backend
       |
       | Spring Data JPA
       v
Hibernate
       |
       v
MySQL Database
