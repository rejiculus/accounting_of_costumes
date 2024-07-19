package com.accounting_of_costumes.api.Location.DTO;

import com.accounting_of_costumes.usercases.Location.DTO.IGetLocationByPlaceData;
import com.accounting_of_costumes.usercases.Place.DTO.IPlacePublicData;

public record GetLocationByPlaceData(IPlacePublicData place) implements IGetLocationByPlaceData {
}
