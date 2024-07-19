package com.accounting_of_costumes.api.Location.Controller;

import com.accounting_of_costumes.api.Location.DTO.CreateLocationData;
import com.accounting_of_costumes.usercases.Location.CreateLocationUserCase;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateLocationController {
    private CreateLocationUserCase userCase;

    public CreateLocationController(CreateLocationUserCase userCase) {
        this.userCase = userCase;
    }

    @PutMapping("/locations")
    public String createLocation(@RequestBody CreateLocationData data){
        return this.userCase.execute(data).toString();
    }
}
