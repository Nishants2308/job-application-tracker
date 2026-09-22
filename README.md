# Job Application Tracker

A REST API for tracking job applications. The project is built with Spring Boot and stores application records in MySQL.

This project demonstrates a straightforward backend flow from HTTP request to controller, service, repository, and database.

## Features

- Create a job application
- View all job applications
- View one job application by ID
- Update an existing job application
- Delete a job application
- Validate required company and job role values
- Return suitable HTTP status codes for common outcomes

## Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- MySQL
- Maven Wrapper

## API Endpoints

Base path: `/api/applications`

| Method | Endpoint | Purpose | Success status |
| --- | --- | --- | --- |
| `POST` | `/api/applications` | Create an application | `201 Created` |
| `GET` | `/api/applications` | Get all applications | `200 OK` |
| `GET` | `/api/applications/{id}` | Get an application by ID | `200 OK` |
| `PUT` | `/api/applications/{id}` | Update an application | `200 OK` |
| `DELETE` | `/api/applications/{id}` | Delete an application | `204 No Content` |

### Error behavior

- A request with a blank company or job role returns `400 Bad Request`.
- A request for a record that does not exist returns `404 Not Found`.

## Project Structure

```text
src/main/java/com/nishanth/jobtracker/
├── JobTrackerApplication.java
├── controller/
│   ├── HomeController.java
│   └── JobApplicationController.java
├── entity/
│   └── JobApplication.java
├── repository/
│   └── JobApplicationRepository.java
└── service/
    └── JobApplicationService.java
```

Package layout can vary slightly by version of the project, but the request flow is:

```text
HTTP request -> Controller -> Service -> Repository -> MySQL
```

## Getting Started

### Prerequisites

Install:

- Java 21
- MySQL 8 or a compatible MySQL version
- Git

The project includes the Maven Wrapper, so a separate Maven installation is not required.

### 1. Clone the repository

```bash
git clone <YOUR_REPOSITORY_URL>
cd <PROJECT_DIRECTORY>
```

### 2. Create the database

Run this statement in MySQL:

```sql
CREATE DATABASE job_tracker;
```

### 3. Configure the database connection

Create or update `src/main/resources/application.properties` locally:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/job_tracker
spring.datasource.username=<YOUR_MYSQL_USERNAME>
spring.datasource.password=<YOUR_MYSQL_PASSWORD>

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace the placeholders with your own local MySQL credentials.

> Never commit a real database password. Keep `application.properties` out of version control if it contains local credentials, or use environment variables instead.

An environment-variable version can look like this:

```properties
spring.datasource.url=${DB_URL:jdbc:mysql://localhost:3306/job_tracker}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Run the application

On Windows:

```bat
mvnw.cmd spring-boot:run
```

On macOS or Linux:

```bash
./mvnw spring-boot:run
```

The API runs at:

```text
http://localhost:8080/api/applications
```

## Example Request

The exact fields should match the `JobApplication` entity in the project. A create request includes at least a non-blank company and job role.

```http
POST /api/applications
Content-Type: application/json
```

```json
{
  "company": "Example Company",
  "jobRole": "Junior Java Developer"
}
```

## Testing

The project currently contains the test generated with the Spring Boot project. A broader automated test suite has not been added yet.

The REST endpoints have been checked manually during development against the local MySQL database.

## Current Scope

This repository is a local backend project. It does not currently include deployment, authentication, authorization, or a frontend.

## Author

**Nishanth S**

Computer Science and Engineering graduate focused on entry-level Java backend development.
