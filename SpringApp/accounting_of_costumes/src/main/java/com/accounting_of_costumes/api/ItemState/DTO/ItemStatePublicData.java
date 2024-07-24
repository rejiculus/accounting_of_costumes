package com.accounting_of_costumes.api.ItemState.DTO;

import com.accounting_of_costumes.entities.ItemState.model.ItemState;
import com.accounting_of_costumes.usercases.ItemState.DTO.IItemStatePublicData;

public record ItemStatePublicData(String name) implements IItemStatePublicData {
    public ItemStatePublicData(ItemState state){
        this(
                state.getName()
        );
    }
}
