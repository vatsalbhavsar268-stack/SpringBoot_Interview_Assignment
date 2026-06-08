package com.interview.assignment.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Student Data Transfer Object (DTO)
 * 
 * Used for API request/response handling.
 * Separating DTOs from entities allows:
 * - Better API versioning
 * - Hiding internal implementation details
 * - Custom serialization/deserialization
 * - Future API changes without affecting the database schema
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {

    private Long id;

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 100, message = "First name must be between 2 and 100 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, max = 100, message = "Last name must be between 2 and 100 characters")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotNull(message = "Age cannot be null")
    @Min(value = 15, message = "Age must be at least 15")
    @Max(value = 100, message = "Age must not exceed 100")
    private Integer age;

    @NotBlank(message = "Grade cannot be blank")
    @Pattern(regexp = "^[A-F]$", message = "Grade must be A, B, C, D, E, or F")
    private String grade;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
