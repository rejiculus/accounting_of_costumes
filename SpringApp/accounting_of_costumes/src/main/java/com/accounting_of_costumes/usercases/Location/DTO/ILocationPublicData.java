package com.accounting_of_costumes.usercases.Location.DTO;

import com.accounting_of_costumes.usercases.Place.DTO.IPlacePublicData;

public interface ILocationPublicData {
    Long id();
    String route();
    IPlacePublicData place();
}
