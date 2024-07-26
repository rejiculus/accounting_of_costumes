package com.accounting_of_costumes.api.Item.DTO;

import com.accounting_of_costumes.entities.Image.model.Image;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import com.accounting_of_costumes.usercases.Item.DTO.ICreateItemData;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public record CreateItemData(String name,
                             int count,
                             String article,
                             LocalDate registrationDate,
                             LocalDate writeOffDate,
                             Long locationId,
                             String itemStateName,
                             Set<Long> imageIds,
                             Set<String> tagNames) implements ICreateItemData {

}
