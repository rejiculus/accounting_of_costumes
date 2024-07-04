package com.accounting_of_costumes.usercases.Item;

import com.accounting_of_costumes.entities.Item.exception.ItemNotFoundException;
import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.entities.Location.exception.LocationNotFoundException;
import com.accounting_of_costumes.entities.Location.gateway.LocationGateway;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.usercases.Location.DTO.ILocationPublicData;

public class GetItemByLocationUserCase {
    private ItemGateway itemGateway;
    private LocationGateway locationGateway;

    public GetItemByLocationUserCase(ItemGateway itemGateway, LocationGateway locationGateway) {
        this.itemGateway = itemGateway;
        this.locationGateway = locationGateway;
    }

    public Item execute(ILocationPublicData data){
        Location location = this.locationGateway.findById(data.id())
                .orElseThrow(() -> new LocationNotFoundException(data.id()));

        return this.itemGateway.findByLocation(location)
                .orElseThrow(() -> new ItemNotFoundException(location));
    }
}
