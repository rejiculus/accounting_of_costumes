package com.accounting_of_costumes.api.Place.Controller;

import com.accounting_of_costumes.usercases.Place.GetPlaceByNameUserCase;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetPlaceByNameController {
    private GetPlaceByNameUserCase userCase;

    public GetPlaceByNameController(GetPlaceByNameUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/place")
    @ResponseBody
    public String getPlaceByName(@RequestParam String name){
        return this.userCase.execute(name).toString();
    }
}
