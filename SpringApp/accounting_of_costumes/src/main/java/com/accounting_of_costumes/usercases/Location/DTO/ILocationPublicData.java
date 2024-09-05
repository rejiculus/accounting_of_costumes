package com.accounting_of_costumes.usercases.Location.DTO;

import com.accounting_of_costumes.api.Location.DTO.LocationsPlacePublicData;

public interface ILocationPublicData {
    Long id();
    String route();
    LocationsPlacePublicData place();
}
