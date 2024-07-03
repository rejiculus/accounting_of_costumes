package com.accounting_of_costumes.usercases.Location;

import com.accounting_of_costumes.entities.Exception.ParamValueException;
import com.accounting_of_costumes.entities.Location.gateway.LocationGateway;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Place.exception.PlaceNotFoundException;
import com.accounting_of_costumes.entities.Place.gateway.PlaceGateway;
import com.accounting_of_costumes.entities.Place.model.Place;
import com.accounting_of_costumes.usercases.Location.DTO.ICreateLocationData;

public class CreateLocationUserCase {
    private LocationGateway locationGateway;
    private PlaceGateway placeGateway;

    public CreateLocationUserCase(LocationGateway locationGateway, PlaceGateway placeGateway){
        this.locationGateway = locationGateway;
        this.placeGateway = placeGateway;
    }

    public Location execute(ICreateLocationData data){
        if(data.route()==null || data.route().isBlank() || data.place()==null)
            throw new ParamValueException("Create Location data cant be null!");

        Place place = placeGateway
                .findById(data.place().id())
                .orElseThrow(() -> new PlaceNotFoundException(data.place().id()));

        Location location = new Location(data.route(),place);
        return this.locationGateway.create(location);
    }
}
