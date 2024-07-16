package com.accounting_of_costumes.api.Place.Controller;

import com.accounting_of_costumes.api.Place.DTO.UpdatePlaceData;
import com.accounting_of_costumes.usercases.Place.UpdatePlaceUserCase;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdatePlaceController {
    private UpdatePlaceUserCase userCase;

    public UpdatePlaceController(UpdatePlaceUserCase userCase) {
        this.userCase = userCase;
    }

    @PutMapping("/place/{id}")
    public String updatePlace(@PathVariable Long id, @RequestBody UpdatePlaceData data){
        return this.userCase.execute(id, data).toString();
    }
}
