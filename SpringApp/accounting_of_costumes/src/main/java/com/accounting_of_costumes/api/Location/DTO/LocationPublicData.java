package com.accounting_of_costumes.api.Location.DTO;

import com.accounting_of_costumes.api.Place.DTO.PlacePublicData;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.usercases.Location.DTO.ILocationPublicData;
import com.accounting_of_costumes.usercases.Place.DTO.IPlacePublicData;

public record LocationPublicData(Long id, String route, IPlacePublicData place) implements ILocationPublicData {
    LocationPublicData(Location location){
        this(
                location.getId(),
                location.getRoute(),
                new PlacePublicData(location.getPlace())
        );
    }
}
