package com.accounting_of_costumes.usercases.Location;

import com.accounting_of_costumes.entities.Location.gateway.LocationGateway;
import com.accounting_of_costumes.entities.Location.model.Location;

import java.util.List;

public class GetAllLocationsUserCase {
    private LocationGateway gateway;

    public GetAllLocationsUserCase(LocationGateway locationGateway){
        this.gateway = locationGateway;
    }

    public List<Location> execute(){
        return this.gateway.findAll();
    }
}
