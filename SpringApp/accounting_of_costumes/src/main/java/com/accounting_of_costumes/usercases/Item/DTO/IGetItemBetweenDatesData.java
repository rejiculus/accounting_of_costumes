package com.accounting_of_costumes.usercases.Item.DTO;

import java.time.LocalDate;

public interface IGetItemBetweenDatesData {
    LocalDate start();
    LocalDate end();
}
