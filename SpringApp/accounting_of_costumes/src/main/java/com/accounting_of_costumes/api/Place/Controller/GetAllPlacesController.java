package com.accounting_of_costumes.api.Place.Controller;

import com.accounting_of_costumes.usercases.Place.GetAllPlacesUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAllPlacesController {
    private GetAllPlacesUserCase userCase;

    public GetAllPlacesController(GetAllPlacesUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/places")
    public String GetAllPlaces(){
        return this.userCase.execute().toString();
    }
}
