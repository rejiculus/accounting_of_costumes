package com.accounting_of_costumes.usercases.Item;

import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.Item.model.Item;

import java.time.LocalDate;
import java.util.List;

public class GetItemByWriteOffDateUserCase {
    private ItemGateway itemGateway;

    public GetItemByWriteOffDateUserCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public List<Item> execute(LocalDate date){
        return this.itemGateway.findByWriteOffDate(date);
    }
}
