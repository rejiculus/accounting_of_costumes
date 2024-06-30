package com.accounting_of_costumes.entities.Exception;

public class ParamValueException extends RuntimeException{
    public ParamValueException(String message){
        super("ParamException: " + message);
    }
}
