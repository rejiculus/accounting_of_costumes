package com.accounting_of_costumes.usercases.Place;

import com.accounting_of_costumes.entities.Place.exception.PlaceNotFoundException;
import com.accounting_of_costumes.entities.Place.gateway.PlaceGateway;
import com.accounting_of_costumes.entities.Place.model.Place;
import com.accounting_of_costumes.usercases.Place.DTO.ICreatePlaceData;

public class CreatePlaceUserCase {
    private PlaceGateway gateway;

    public CreatePlaceUserCase(PlaceGateway placeGateway){
        this.gateway = placeGateway;
    }

    public Place execute(ICreatePlaceData data){
        Place place = new Place(data.name());
        return this.gateway.create(place);
    }
}
