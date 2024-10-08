package com.accounting_of_costumes.usercases.Item.DTO;

import com.accounting_of_costumes.usercases.ItemState.DTO.IItemStatePublicData;
import com.accounting_of_costumes.usercases.Location.DTO.ILocationPublicData;

import java.time.LocalDate;
import java.util.Set;


public interface IItemPublicData {
    Long id();
    String name();
    int count();
    String article();

    LocalDate registrationDate();
    LocalDate writeOffDate();

    ILocationPublicData location();
    IItemStatePublicData itemState();
}
