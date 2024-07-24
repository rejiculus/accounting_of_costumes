package com.accounting_of_costumes.usercases.Item.DTO;

import java.time.LocalDate;
import java.util.Set;

public interface ICreateItemData {
    String name();
    int count();
    String article();
    LocalDate registrationDate();
    LocalDate writeOffDate();
    Long locationId();
    String itemStateName();
    Set<Long> imageIds();
    Set<String> tagNames();
}
