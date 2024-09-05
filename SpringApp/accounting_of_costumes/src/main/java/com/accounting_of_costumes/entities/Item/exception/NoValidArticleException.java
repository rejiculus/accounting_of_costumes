package com.accounting_of_costumes.entities.Item.exception;

public class NoValidArticleException extends RuntimeException{
    public NoValidArticleException(String article) {
        super(String.format("Article '%s' is not valid!%n", article));
    }
}
