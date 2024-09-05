package com.accounting_of_costumes.entities.Location.exception;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(Long id) {
        super(String.format("Location '%s' is not found!%n", id));
    }
    public LocationNotFoundException(String route) {
        super(String.format("Location '%s' is not found!%n", route));
    }
}
