package com.accounting_of_costumes.usercases.ItemState;

import com.accounting_of_costumes.entities.ItemState.gateway.ItemStateGateway;
import com.accounting_of_costumes.entities.ItemState.model.ItemState;
import com.accounting_of_costumes.usercases.ItemState.DTO.ICreateItemStateData;

import java.util.List;

public class CreateItemStateUserCase {
    private ItemStateGateway itemStateGateway;

    public CreateItemStateUserCase(ItemStateGateway itemStateGateway) {
        this.itemStateGateway = itemStateGateway;
    }

    public ItemState execute(ICreateItemStateData data){
        ItemState state = new ItemState(data.name());
        return this.itemStateGateway.create(state);
    }
}
