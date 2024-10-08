package com.accounting_of_costumes.api.Location.DTO;

import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.usercases.Location.DTO.IUpdateLocationData;
import com.accounting_of_costumes.usercases.Place.DTO.IPlacePublicData;

public record UpdateLocationData(Long id, String route, Long placeId) implements IUpdateLocationData {
    public UpdateLocationData(Location location){
        this(
                location.getId(),
                location.getRoute(),
                location.getPlace().getId()
        );
    }
}
