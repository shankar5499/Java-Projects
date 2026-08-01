# Student Management System

A console-based Student Management System built in Core Java, demonstrating
Object-Oriented Programming, Collections, File I/O (object serialization for
persistence), and custom exception handling.

## Features
- Add, view, update, delete student records
- Search students by name
- Calculate average marks of all students
- Data persists between runs using Java Object Serialization (no external
  database required to run)

## Tech Stack
- Core Java (JDK 17+)
- Collections Framework (ArrayList)
- Java I/O (Serialization)
- Custom Exception Handling

## How to Run
```bash
cd src
javac *.java
java Main
```

## Project Structure
```
StudentManagementSystem/
├── src/
│   ├── Main.java                  # Console menu / entry point
│   ├── Student.java               # Student model (POJO)
│   ├── StudentService.java        # Business logic + persistence
│   └── StudentNotFoundException.java
└── README.md
```

## Possible Extensions (good talking points for interviews)
- Replace file-based storage with JDBC + MySQL
- Add a Spring Boot REST API layer on top of the same service logic
- Add input validation and unit tests (JUnit)
