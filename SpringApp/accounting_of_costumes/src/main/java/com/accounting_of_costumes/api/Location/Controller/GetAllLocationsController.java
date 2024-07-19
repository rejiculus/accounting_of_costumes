package com.accounting_of_costumes.api.Location.Controller;

import com.accounting_of_costumes.usercases.Location.GetAllLocationsUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAllLocationsController {
    private GetAllLocationsUserCase userCase;

    public GetAllLocationsController(GetAllLocationsUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/locations")
    public String getAllLocations(){
        return this.userCase.execute().toString();
    }
}
