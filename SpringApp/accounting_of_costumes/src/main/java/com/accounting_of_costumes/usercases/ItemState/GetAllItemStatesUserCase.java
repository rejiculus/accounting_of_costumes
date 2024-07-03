package com.accounting_of_costumes.usercases.ItemState;

import com.accounting_of_costumes.entities.ItemState.gateway.ItemStateGateway;
import com.accounting_of_costumes.entities.ItemState.model.ItemState;
import com.accounting_of_costumes.usercases.Location.GetLocationByPlaceUserCase;

import java.util.List;

public class GetAllItemStatesUserCase {
    private ItemStateGateway itemStateGateway;

    public GetAllItemStatesUserCase(ItemStateGateway itemStateGateway) {
        this.itemStateGateway = itemStateGateway;
    }

    public List<ItemState> execute(){
        return this.itemStateGateway.findAll();
    }

}
