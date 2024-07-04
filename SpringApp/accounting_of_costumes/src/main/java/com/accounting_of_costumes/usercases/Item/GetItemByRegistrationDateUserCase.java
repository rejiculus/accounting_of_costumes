package com.accounting_of_costumes.usercases.Item;

import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.Item.model.Item;

import java.time.LocalDate;
import java.util.List;

public class GetItemByRegistrationDateUserCase {
    private ItemGateway itemGateway;

    public GetItemByRegistrationDateUserCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public List<Item> execute(LocalDate date){
        return this.itemGateway.findByRegistrationDate(date);
    }
}
