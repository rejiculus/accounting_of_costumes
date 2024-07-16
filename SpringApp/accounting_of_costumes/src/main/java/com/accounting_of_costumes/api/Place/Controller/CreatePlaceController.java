package com.accounting_of_costumes.api.Place.Controller;

import com.accounting_of_costumes.api.Place.DTO.CreatePlaceData;
import com.accounting_of_costumes.usercases.Place.CreatePlaceUserCase;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreatePlaceController {
    private CreatePlaceUserCase userCase;

    public CreatePlaceController(CreatePlaceUserCase userCase) {
        this.userCase = userCase;
    }

    @PutMapping("/place/")
    public String createPlace(@RequestBody CreatePlaceData data){
        return this.userCase.execute(data).toString();
    }
}
