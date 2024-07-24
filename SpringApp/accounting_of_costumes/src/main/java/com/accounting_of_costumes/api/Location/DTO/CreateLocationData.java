package com.accounting_of_costumes.api.Location.DTO;

import com.accounting_of_costumes.usercases.Location.DTO.ICreateLocationData;
import com.accounting_of_costumes.usercases.Place.DTO.IPlacePublicData;

public record CreateLocationData(String route, Long placeId) implements ICreateLocationData {
}
