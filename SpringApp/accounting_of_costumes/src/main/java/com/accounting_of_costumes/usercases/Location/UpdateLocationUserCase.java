package com.accounting_of_costumes.usercases.Location;

import com.accounting_of_costumes.entities.Exception.ParamValueException;
import com.accounting_of_costumes.entities.Location.exception.LocationNotFoundException;
import com.accounting_of_costumes.entities.Location.gateway.LocationGateway;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Place.exception.PlaceNotFoundException;
import com.accounting_of_costumes.entities.Place.gateway.PlaceGateway;
import com.accounting_of_costumes.entities.Place.model.Place;
import com.accounting_of_costumes.usercases.Location.DTO.ICreateLocationData;
import com.accounting_of_costumes.usercases.Location.DTO.IUpdateLocationData;

public class UpdateLocationUserCase {
    private LocationGateway locationGateway;
    private PlaceGateway placeGateway;

    public UpdateLocationUserCase(LocationGateway locationGateway, PlaceGateway placeGateway){
        this.locationGateway = locationGateway;
        this.placeGateway = placeGateway;
    }

    public Location execute(IUpdateLocationData data){
        if(data.route()==null || data.route().isBlank() || data.placeId()==null)
            throw new ParamValueException("Create Location data cant be null!");

        Location location = this.locationGateway
                .findById(data.id())
                .orElseThrow(() -> new LocationNotFoundException(data.id()));

        Place place = placeGateway
                .findById(data.placeId())
                .orElseThrow(() -> new PlaceNotFoundException(data.placeId()));

        location.setRoute(data.route());
        location.setPlace(place);

        return this.locationGateway.update(location);
    }
}
