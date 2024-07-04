package com.accounting_of_costumes.usercases.Item;

import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.Item.model.Item;

import java.util.List;

public class GetAllItemUserCase {
    private ItemGateway itemGateway;

    public GetAllItemUserCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public List<Item> execute(){
        return this.itemGateway.findAll();
    }
}
