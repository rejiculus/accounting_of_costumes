package com.accounting_of_costumes.usercases.Item;

import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.Item.model.Item;

import java.util.List;

public class GetItemByNameUserCase {
    private ItemGateway itemGateway;

    public GetItemByNameUserCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public List<Item> execute(String name){
        return this.itemGateway.findByName(name);
    }
}
