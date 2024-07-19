package com.accounting_of_costumes.api.Location.Controller;

import com.accounting_of_costumes.api.Location.DTO.GetLocationByPlaceData;
import com.accounting_of_costumes.api.Place.DTO.PlacePublicData;
import com.accounting_of_costumes.usercases.Location.GetLocationByPlaceUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetLocationByPlaceController {
    private GetLocationByPlaceUserCase userCase;

    public GetLocationByPlaceController(GetLocationByPlaceUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/locations/")
    public String getLocationByPlace(@RequestBody PlacePublicData data){
        return this.userCase.execute(data).toString();
    }
}
