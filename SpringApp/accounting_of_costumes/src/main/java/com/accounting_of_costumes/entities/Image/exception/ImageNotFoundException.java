package com.accounting_of_costumes.entities.Image.exception;

public class ImageNotFoundException extends RuntimeException{
    public ImageNotFoundException(String source){
        super(String.format("Image by source '%s' is not found!",source));
    }
}
