package com.accounting_of_costumes.usercases.Location;

import com.accounting_of_costumes.entities.Location.exception.LocationNotFoundException;
import com.accounting_of_costumes.entities.Location.gateway.LocationGateway;
import com.accounting_of_costumes.entities.Location.model.Location;

import java.util.List;

public class GetLocationByRouteUserCase {
    private LocationGateway gateway;

    public GetLocationByRouteUserCase(LocationGateway locationGateway){
        this.gateway = locationGateway;
    }

    public Location execute(String route){
        return this.gateway
                .findByRoute(route)
                .orElseThrow(() -> new LocationNotFoundException(route));
    }
}
