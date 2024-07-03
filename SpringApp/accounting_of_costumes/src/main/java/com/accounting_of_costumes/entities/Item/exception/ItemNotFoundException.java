package com.accounting_of_costumes.entities.Item.exception;

import com.accounting_of_costumes.entities.Location.model.Location;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(Long id){
        super(String.format("Item '%d' is not found!", id));
    }
    public ItemNotFoundException(String article){
        super(String.format("Item '%s' is not found!", article));
    }
    public ItemNotFoundException(Location location){
        super(String.format("Item with location '%s' is not found!", location.getRoute()));
    }
}
