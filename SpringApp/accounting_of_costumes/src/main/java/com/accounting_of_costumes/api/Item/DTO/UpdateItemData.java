package com.accounting_of_costumes.api.Item.DTO;

import com.accounting_of_costumes.usercases.Item.DTO.IUpdateItemData;

import java.time.LocalDate;
import java.util.Set;

public record UpdateItemData(Long id,
                             String name,
                             int count,
                             String article,
                             LocalDate registrationDate,
                             LocalDate writeOffDate,
                             Long locationId,
                             String itemStateName,
                             Set<Long> imageIds,
                             Set<String> tagNames) implements IUpdateItemData {
}
