package com.accounting_of_costumes.usercases.Location;

import com.accounting_of_costumes.entities.Exception.ParamValueException;
import com.accounting_of_costumes.entities.Location.gateway.LocationGateway;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Place.exception.PlaceNotFoundException;
import com.accounting_of_costumes.entities.Place.gateway.PlaceGateway;
import com.accounting_of_costumes.entities.Place.model.Place;
import com.accounting_of_costumes.usercases.Place.DTO.IPlacePublicData;

import java.util.List;

public class GetLocationByPlaceUserCase {
    private LocationGateway locationGateway;
    private PlaceGateway placeGateway;

    public GetLocationByPlaceUserCase(LocationGateway locationGateway, PlaceGateway placeGateway){
        this.locationGateway = locationGateway;
        this.placeGateway = placeGateway;
    }

    public List<Location> execute(IPlacePublicData data){
        if(data.id()==null)
            throw new ParamValueException("Param 'place' cant be null!");

        Place place = this.placeGateway.findById(data.id())
                .orElseThrow(()-> new PlaceNotFoundException(data.id()));

        return this.locationGateway.findByPlace(place);
    }
}
