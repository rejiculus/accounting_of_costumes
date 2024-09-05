package com.accounting_of_costumes.entities.Item.exception;

import java.time.LocalDate;

public class NoValidDateException extends RuntimeException{
    public NoValidDateException(LocalDate registrationDate, LocalDate writeOffDate) {
        super(String.format("Write off date(%s) have to be after then registration date(%s)!%n", writeOffDate,registrationDate));
    }
}
