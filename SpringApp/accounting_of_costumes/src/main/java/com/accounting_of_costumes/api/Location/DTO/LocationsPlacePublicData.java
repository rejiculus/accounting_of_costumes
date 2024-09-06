package com.accounting_of_costumes.api.Location.DTO;

import com.accounting_of_costumes.entities.Place.model.Place;

public record LocationsPlacePublicData(Long id, String name, String url) {
    public LocationsPlacePublicData(Place place){
        this(
            place.getId(),
            place.getName(),
            "/places/"+place.getId()
        );
    }
}
