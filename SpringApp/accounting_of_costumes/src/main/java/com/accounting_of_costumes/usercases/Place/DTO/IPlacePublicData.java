package com.accounting_of_costumes.usercases.Place.DTO;

import java.util.HashMap;
import java.util.Map;

public interface IPlacePublicData {
    Long id();
    String name();
    Map<Long,String> locations();
}
