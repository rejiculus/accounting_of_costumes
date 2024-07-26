package com.accounting_of_costumes.api.Item.DTO;

import com.accounting_of_costumes.usercases.Item.DTO.IGetItemBetweenDatesData;

import java.time.LocalDate;

public record GetItemBetweenDatesData(LocalDate start, LocalDate end) implements IGetItemBetweenDatesData {
}
