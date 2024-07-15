package com.accounting_of_costumes.usercases.Place;

import com.accounting_of_costumes.entities.Place.gateway.PlaceGateway;
import com.accounting_of_costumes.entities.Place.model.Place;

import java.util.List;

public class GetAllPlacesUserCase {
    private PlaceGateway gateway;

    public GetAllPlacesUserCase(PlaceGateway placeGateway){
        this.gateway = placeGateway;
    }

    public List<Place> execute(){
        return this.gateway.findAll();
    }
}
