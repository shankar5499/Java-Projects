# Employee Management REST API

A RESTful API built with Spring Boot for managing employee records — full
CRUD operations, input validation, and global exception handling.

## Features
- Create, read, update, delete employee records
- Search employees by department
- Bean validation (name, email format, positive salary)
- Centralized exception handling with clean JSON error responses
- In-memory H2 database (zero setup — runs out of the box)

## Tech Stack
- Java 17
- Spring Boot 3.2 (Spring Web, Spring Data JPA)
- H2 Database
- Maven

## How to Run
```bash
mvn spring-boot:run
```
API will be available at `http://localhost:8080/api/employees`
H2 console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:employeedb`)

## API Endpoints
| Method | Endpoint                          | Description                  |
|--------|------------------------------------|-------------------------------|
| GET    | /api/employees                     | Get all employees            |
| GET    | /api/employees/{id}                | Get employee by ID           |
| POST   | /api/employees                     | Create a new employee        |
| PUT    | /api/employees/{id}                | Update an employee            |
| DELETE | /api/employees/{id}                | Delete an employee            |
| GET    | /api/employees/department/{dept}   | Get employees by department  |

## Sample Request (POST)
```json
{
  "name": "Ravi Kumar",
  "email": "ravi@example.com",
  "department": "Engineering",
  "salary": 55000
}
```

## Project Structure
```
EmployeeManagementAPI/
├── pom.xml
└── src/main/
    ├── java/com/example/employeeapi/
    │   ├── EmployeeApiApplication.java
    │   ├── model/Employee.java
    │   ├── repository/EmployeeRepository.java
    │   ├── service/EmployeeService.java
    │   ├── controller/EmployeeController.java
    │   └── exception/ (ResourceNotFoundException, GlobalExceptionHandler)
    └── resources/application.properties
```
