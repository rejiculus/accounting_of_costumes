package com.accounting_of_costumes.entities.Image.exception;

public class NoValidSourceException extends RuntimeException{
    public NoValidSourceException() {
        super("Source can't be null or empty!\n");
    }
}
