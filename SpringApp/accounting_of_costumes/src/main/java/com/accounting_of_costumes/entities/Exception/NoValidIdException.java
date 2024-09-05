package com.accounting_of_costumes.entities.Exception;

public class NoValidIdException extends RuntimeException{
    public NoValidIdException(Long id){
        super(String.format("Id '%d' is no valid! Id have to be more than zero!%n", id));
    }
}
