package com.accounting_of_costumes.api.Place.Controller;

import com.accounting_of_costumes.usercases.Place.GetPlaceByNameUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class GetPlaceByNameController {
    private GetPlaceByNameUserCase userCase;

    public GetPlaceByNameController(GetPlaceByNameUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping(name = "/place/{name}")
    public String getPlaceByName(@PathVariable String name){
        return this.userCase.execute(name).toString();
    }
}
