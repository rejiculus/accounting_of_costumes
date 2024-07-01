package com.accounting_of_costumes.usercases.Place;

import com.accounting_of_costumes.entities.Place.exception.PlaceNotFoundException;
import com.accounting_of_costumes.entities.Place.gateway.PlaceGateway;
import com.accounting_of_costumes.entities.Place.model.Place;

public class DeletePlaceUserCase {
    private PlaceGateway gateway;

    public DeletePlaceUserCase(PlaceGateway placeGateway){
        this.gateway = placeGateway;
    }

    public void execute(Long id){
        Place place = this.gateway
                .findById(id)
                .orElseThrow(() -> new PlaceNotFoundException(id));
        this.gateway.delete(place);
    }
}
