package com.interview.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Student Management API application.
 * 
 * This is a simple yet scalable Spring Boot application demonstrating:
 * - RESTful API design
 * - Database interaction using JPA
 * - H2 in-memory database
 * - Layered architecture (Controller -> Service -> Repository)
 * - Proper exception handling
 * 
 * Future enhancements can include:
 * - Authentication/Authorization
 * - Multiple endpoints
 * - Advanced validation
 * - Caching strategies
 * - API documentation with Swagger
 */
@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }
}
