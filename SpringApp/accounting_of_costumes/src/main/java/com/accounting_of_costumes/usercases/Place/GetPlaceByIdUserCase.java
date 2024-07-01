package com.accounting_of_costumes.usercases.Place;

import com.accounting_of_costumes.entities.Place.exception.PlaceNotFoundException;
import com.accounting_of_costumes.entities.Place.gateway.PlaceGateway;
import com.accounting_of_costumes.entities.Place.model.Place;

import java.util.List;

public class GetPlaceByIdUserCase {
    private PlaceGateway gateway;

    public GetPlaceByIdUserCase(PlaceGateway placeGateway){
        this.gateway = placeGateway;
    }

    public Place execute(Long id){
        return this.gateway
                .findById(id)
                .orElseThrow(() -> new PlaceNotFoundException(id));
    }
}
