package com.accounting_of_costumes.api.Place.DTO;

import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Place.model.Place;
import com.accounting_of_costumes.usercases.Place.DTO.IPlacePublicData;

import java.util.Map;
import java.util.stream.Collectors;

public record PlacePublicData(Long id, String name, Map<Long,String> locations) implements IPlacePublicData {
    public PlacePublicData(Place place){
        this(
                place.getId(),
                place.getName(),
                place.getLocations().stream().collect(Collectors.toMap(Location::getId, Location::getRoute))
        );
    }
}
