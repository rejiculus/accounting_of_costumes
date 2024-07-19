package com.accounting_of_costumes.api.Location.Controller;

import com.accounting_of_costumes.usercases.Location.GetLocationByIdUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetLocationByIdController {
    private GetLocationByIdUserCase userCase;

    public GetLocationByIdController(GetLocationByIdUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/locations/{id}")
    public String getLocationById(@PathVariable Long id){
        return this.userCase.execute(id).toString();
    }
}
