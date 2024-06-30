package com.accounting_of_costumes.entities.ItemState.exception;

public class ItemStateNotFoundException extends RuntimeException{
    public ItemStateNotFoundException(String name){
        super(String.format("Item state '%s' is not found!", name));
    }
}
