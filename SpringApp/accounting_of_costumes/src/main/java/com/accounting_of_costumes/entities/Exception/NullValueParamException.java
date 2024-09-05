package com.accounting_of_costumes.entities.Exception;

public class NullValueParamException extends RuntimeException{
    public NullValueParamException(String paramName) {
        super(String.format("Param '%s' can't be null!%n", paramName));
    }
}
