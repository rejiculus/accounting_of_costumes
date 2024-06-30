package com.accounting_of_costumes.entities.Place.exception;

public class PlaceNotFoundException extends RuntimeException{
    public PlaceNotFoundException(String name){
        super(String.format("Place '%s' is not found!",name));
    }
    public PlaceNotFoundException(Long id){
        super(String.format("Place '%d' is not found!", id));
    }
}
