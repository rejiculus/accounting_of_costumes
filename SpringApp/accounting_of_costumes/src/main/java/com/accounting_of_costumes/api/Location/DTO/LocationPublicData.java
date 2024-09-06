package com.accounting_of_costumes.api.Location.DTO;

import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.usercases.Location.DTO.ILocationPublicData;

public record LocationPublicData(Long id, String route, LocationsPlacePublicData place) implements ILocationPublicData {
    public LocationPublicData(Location location){
        this(
                location.getId(),
                location.getRoute(),
                new LocationsPlacePublicData(location.getPlace())
        );
    }
}
