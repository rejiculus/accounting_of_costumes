package com.accounting_of_costumes.entities.Location.exception;

public class NoValidRouteException extends RuntimeException{
    public NoValidRouteException(){
        super("Route can't be null or empty!\n");
    }
}
