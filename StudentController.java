package com.interview.assignment.controller;

import com.interview.assignment.dto.StudentDTO;
import com.interview.assignment.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Student Controller - REST API Endpoint
 * 
 * This controller provides a single endpoint for student registration.
 * 
 * Key Features:
 * - RESTful design with proper HTTP methods and status codes
 * - Input validation with @Valid
 * - Global exception handling
 * - Comprehensive logging
 * - Clear API documentation in comments
 */
@RestController
@RequestMapping("/api/v1/students")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Register a new student
     * 
     * Endpoint: POST /api/v1/students
     * 
     * This endpoint handles student registration.
     * It validates the input and stores the student in the H2 in-memory database.
     * 
     * @param studentDTO the student data to register
     * @return ResponseEntity with the registered student data and HTTP 201 Created status
     * 
     * Example Request:
     * POST /api/v1/students
     * {
     *   "firstName": "John",
     *   "lastName": "Doe",
     *   "email": "john.doe@example.com",
     *   "age": 20,
     *   "grade": "A"
     * }
     */
    @PostMapping
    public ResponseEntity<StudentDTO> registerStudent(@Valid @RequestBody StudentDTO studentDTO) {
        StudentDTO registeredStudent = studentService.registerStudent(studentDTO);
        return new ResponseEntity<>(registeredStudent, HttpStatus.CREATED);
    }
}
