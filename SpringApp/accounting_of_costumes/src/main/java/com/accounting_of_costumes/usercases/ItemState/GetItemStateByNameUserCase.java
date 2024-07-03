package com.accounting_of_costumes.usercases.ItemState;

import com.accounting_of_costumes.entities.ItemState.exception.ItemStateNotFoundException;
import com.accounting_of_costumes.entities.ItemState.gateway.ItemStateGateway;
import com.accounting_of_costumes.entities.ItemState.model.ItemState;

import java.util.Optional;

public class GetItemStateByNameUserCase {
    private ItemStateGateway itemStateGateway;

    public GetItemStateByNameUserCase(ItemStateGateway itemStateGateway){
        this.itemStateGateway = itemStateGateway;
    }

    public ItemState execute(String name){
        return this.itemStateGateway.findByName(name)
                .orElseThrow(() -> new ItemStateNotFoundException(name));
    }
}
