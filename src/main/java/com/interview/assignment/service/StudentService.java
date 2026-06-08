package com.interview.assignment.service;

import com.interview.assignment.dto.StudentDTO;
import com.interview.assignment.entity.Student;
import com.interview.assignment.exception.DuplicateResourceException;
import com.interview.assignment.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Student Service class.
 * 
 * Contains business logic for student operations.
 * This layer abstracts the database operations and provides:
 * - Data validation
 * - Error handling
 * - Logging
 * - Transaction management
 */
@Service
@Slf4j
@Transactional
public class StudentService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Register a new student.
     * 
     * @param studentDTO the student data
     * @return the registered student
     * @throws DuplicateResourceException if email already exists
     */
    public StudentDTO registerStudent(StudentDTO studentDTO) {
        log.info("Registering new student with email: {}", studentDTO.getEmail());

        // Validate that email doesn't already exist
        if (studentRepository.existsByEmail(studentDTO.getEmail())) {
            log.warn("Student registration failed: duplicate email: {}", studentDTO.getEmail());
            throw new DuplicateResourceException("Email already exists: " + studentDTO.getEmail());
        }

        // Convert DTO to Entity
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());
        student.setGrade(studentDTO.getGrade());

        // Save to database
        Student savedStudent = studentRepository.save(student);
        log.info("Student registered successfully with id: {}", savedStudent.getId());

        // Convert Entity to DTO and return
        return convertToDTO(savedStudent);
    }

    /**
     * Convert Student entity to StudentDTO.
     * 
     * @param student the student entity
     * @return the student DTO
     */
    private StudentDTO convertToDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .age(student.getAge())
                .grade(student.getGrade())
                .createdAt(student.getCreatedAt())
                .updatedAt(student.getUpdatedAt())
                .build();
    }
}
