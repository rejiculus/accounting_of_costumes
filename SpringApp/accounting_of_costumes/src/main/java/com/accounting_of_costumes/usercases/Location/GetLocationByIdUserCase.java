package com.accounting_of_costumes.usercases.Location;

import com.accounting_of_costumes.entities.Location.exception.LocationNotFoundException;
import com.accounting_of_costumes.entities.Location.gateway.LocationGateway;
import com.accounting_of_costumes.entities.Location.model.Location;

import java.util.List;

public class GetLocationByIdUserCase {
    private LocationGateway gateway;

    public GetLocationByIdUserCase(LocationGateway locationGateway){
        this.gateway = locationGateway;
    }

    public Location execute(Long id){
        return this.gateway
                .findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
    }
}
