package com.accounting_of_costumes.usercases.Place;

import com.accounting_of_costumes.entities.Exception.ParamValueException;
import com.accounting_of_costumes.entities.Place.exception.PlaceNotFoundException;
import com.accounting_of_costumes.entities.Place.gateway.PlaceGateway;
import com.accounting_of_costumes.entities.Place.model.Place;
import com.accounting_of_costumes.usercases.Place.DTO.IUpdatePlaceData;

public class UpdatePlaceUserCase {
    private PlaceGateway gateway;

    public UpdatePlaceUserCase(PlaceGateway placeGateway){
        this.gateway = placeGateway;
    }

    public Place execute(Long id, IUpdatePlaceData data){
        if(data.name() == null || data.name().isBlank())
            throw new ParamValueException("Place name cant be empty!");

        Place place = this.gateway
                .findById(id)
                .orElseThrow(() -> new PlaceNotFoundException(id));

        place.setName(data.name());

        return this.gateway.update(place);
    }
}
