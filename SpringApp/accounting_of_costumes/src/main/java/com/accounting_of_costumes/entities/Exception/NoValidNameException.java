package com.accounting_of_costumes.entities.Exception;

public class NoValidNameException extends RuntimeException {
    public NoValidNameException(String name) {
        super(String.format("Name '%s' is no valid!%n", name));
    }
}
