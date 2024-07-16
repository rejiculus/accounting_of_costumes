package com.accounting_of_costumes.api.Place.Controller;

import com.accounting_of_costumes.usercases.Place.DeletePlaceUserCase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeletePlaceController {
    private DeletePlaceUserCase userCase;

    public DeletePlaceController(DeletePlaceUserCase userCase) {
        this.userCase = userCase;
    }

    @DeleteMapping("/place/{id}")
    public String deletePlace(@PathVariable Long id){
        this.userCase.execute(id);
        return String.format("Place %d has delete!", id);
    }
}
