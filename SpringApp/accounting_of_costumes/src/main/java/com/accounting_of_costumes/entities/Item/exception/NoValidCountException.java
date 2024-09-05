package com.accounting_of_costumes.entities.Item.exception;

public class NoValidCountException extends RuntimeException{
    public NoValidCountException(int count){
        super(String.format("Count '%d' have to be more then zero!%n", count));
    }
}
