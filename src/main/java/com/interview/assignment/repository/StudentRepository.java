package com.interview.assignment.repository;

import com.interview.assignment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Student Repository interface.
 * 
 * Extends JpaRepository to provide database operations.
 * Spring Data JPA automatically implements this interface and provides:
 * - CRUD operations
 * - Pagination and sorting
 * - Custom query methods
 * 
 * This design allows for easy database migrations or caching strategies
 * in the future without changing the service layer.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * Check if a student with given email exists.
     * Useful for validation before creating new students.
     * 
     * @param email the student's email
     * @return true if student exists, false otherwise
     */
    boolean existsByEmail(String email);
}
