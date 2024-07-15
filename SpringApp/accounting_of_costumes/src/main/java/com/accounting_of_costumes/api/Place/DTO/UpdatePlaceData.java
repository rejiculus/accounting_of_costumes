package com.accounting_of_costumes.api.Place.DTO;

import com.accounting_of_costumes.usercases.Place.DTO.IUpdatePlaceData;

public record UpdatePlaceData(String name) implements IUpdatePlaceData {
}
