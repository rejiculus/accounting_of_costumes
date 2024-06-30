package com.accounting_of_costumes.entities.Location.exception;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(String route) {
        super(String.format("Location '%s' is not found!", route));
    }
}
