package com.accounting_of_costumes.usercases.Item;

import com.accounting_of_costumes.entities.Exception.ParamValueException;
import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.usercases.Item.DTO.IGetItemBetweenDatesData;

import java.util.List;

public class GetItemByWriteOffDateBetweenUserCase {
    private ItemGateway itemGateway;

    public GetItemByWriteOffDateBetweenUserCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public List<Item> execute(IGetItemBetweenDatesData data){
        if(data.start().isAfter(data.end()))
            throw new ParamValueException("Violation of cause-and-effect relationship! End date before start date!");
        return this.itemGateway.findBetweenWriteOffDate(data.start(), data.end());
    }
}
