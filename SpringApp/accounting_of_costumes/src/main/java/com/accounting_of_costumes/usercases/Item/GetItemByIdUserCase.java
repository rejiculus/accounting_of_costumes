package com.accounting_of_costumes.usercases.Item;

import com.accounting_of_costumes.entities.Item.exception.ItemNotFoundException;
import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.Item.model.Item;

import java.util.List;

public class GetItemByIdUserCase {
    private ItemGateway itemGateway;

    public GetItemByIdUserCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public Item execute(Long id){
        return this.itemGateway.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }
}
