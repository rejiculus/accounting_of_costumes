package com.accounting_of_costumes.usercases.Item;

import com.accounting_of_costumes.entities.Item.exception.ItemNotFoundException;
import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.Item.model.Item;

public class DeleteItemUserCase {
    private ItemGateway itemGateway;

    public DeleteItemUserCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public void execute(Long id){
        Item item = this.itemGateway.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        this.itemGateway.delete(item);
    }
}
