package com.accounting_of_costumes.usercases.Place;

import com.accounting_of_costumes.entities.Place.exception.PlaceNotFoundException;
import com.accounting_of_costumes.entities.Place.gateway.PlaceGateway;
import com.accounting_of_costumes.entities.Place.model.Place;

public class GetPlaceByNameUserCase {
    private PlaceGateway gateway;

    public GetPlaceByNameUserCase(PlaceGateway placeGateway){
        this.gateway = placeGateway;
    }

    public Place execute(String name){
        return this.gateway
                .findByName(name)
                .orElseThrow(() -> new PlaceNotFoundException(name));
    }
}
