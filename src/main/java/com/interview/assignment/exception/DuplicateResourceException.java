package com.interview.assignment.exception;

/**
 * Custom exception for duplicate resource scenarios.
 * Thrown when attempting to create a resource that already exists (e.g., duplicate email).
 */
public class DuplicateResourceException extends RuntimeException {
    
    public DuplicateResourceException(String message) {
        super(message);
    }

    public DuplicateResourceException(String message, Throwable cause) {
        super(message, cause);
    }
}
