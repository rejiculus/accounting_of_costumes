package com.accounting_of_costumes.api.Place.Controller;

import com.accounting_of_costumes.usercases.Place.GetPlaceByIdUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPlaceByIdController {
    private GetPlaceByIdUserCase userCase;

    public GetPlaceByIdController(GetPlaceByIdUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping(name = "/place/{id}")
    public String getPlaceById(@PathVariable Long id){
        return this.userCase.execute(id).toString();
    }
}
