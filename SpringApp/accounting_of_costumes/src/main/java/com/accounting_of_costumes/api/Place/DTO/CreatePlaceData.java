package com.accounting_of_costumes.api.Place.DTO;

import com.accounting_of_costumes.usercases.Place.DTO.ICreatePlaceData;

public record CreatePlaceData(String name) implements ICreatePlaceData {
}
