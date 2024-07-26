package com.accounting_of_costumes.api.Item.DTO;

import com.accounting_of_costumes.api.ItemState.DTO.ItemStatePublicData;
import com.accounting_of_costumes.api.Location.DTO.LocationPublicData;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.usercases.Item.DTO.IItemPublicData;
import com.accounting_of_costumes.usercases.ItemState.DTO.IItemStatePublicData;
import com.accounting_of_costumes.usercases.Location.DTO.ILocationPublicData;

import java.time.LocalDate;

public record ItemPublicData(
        Long id,
        String name,
        int count,
        String article,
        LocalDate registrationDate,
        LocalDate writeOffDate,
        ILocationPublicData location,
        IItemStatePublicData itemState
) implements IItemPublicData {
    public ItemPublicData(Item item){
        this(
                item.getId(),
                item.getName(),
                item.getCount(),
                item.getArticle(),
                item.getRegistrationDate(),
                item.getWriteOffDate(),
                new LocationPublicData(item.getLocation()),
                new ItemStatePublicData(item.getItemState())

        );
    }
}
