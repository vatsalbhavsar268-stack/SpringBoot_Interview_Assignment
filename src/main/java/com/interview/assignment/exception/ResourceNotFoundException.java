package com.interview.assignment.exception;

/**
 * Custom exception for resource not found scenarios.
 * Provides clear error messages and can be caught globally by exception handlers.
 */
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
