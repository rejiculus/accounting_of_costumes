package com.accounting_of_costumes.entities.Tag.exception;

public class TagNotFoundException extends RuntimeException{
    public TagNotFoundException(String name){
        super(String.format("TagNotFoundException: Tag '%s' is not found!%n",name));
    }
}
