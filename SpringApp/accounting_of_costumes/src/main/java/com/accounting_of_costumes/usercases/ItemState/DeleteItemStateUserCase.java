package com.accounting_of_costumes.usercases.ItemState;

import com.accounting_of_costumes.entities.ItemState.exception.ItemStateNotFoundException;
import com.accounting_of_costumes.entities.ItemState.gateway.ItemStateGateway;
import com.accounting_of_costumes.entities.ItemState.model.ItemState;

public class DeleteItemStateUserCase {
    private ItemStateGateway itemStateGateway;

    public DeleteItemStateUserCase(ItemStateGateway itemStateGateway){
        this.itemStateGateway = itemStateGateway;
    }

    public void execute(String name){
        ItemState itemState = this.itemStateGateway.findByName(name)
                .orElseThrow(() -> new ItemStateNotFoundException(name));

        this.itemStateGateway.delete(itemState);
    }
}
