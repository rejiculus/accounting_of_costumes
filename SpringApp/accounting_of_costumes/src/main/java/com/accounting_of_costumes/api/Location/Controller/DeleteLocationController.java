package com.accounting_of_costumes.api.Location.Controller;

import com.accounting_of_costumes.usercases.Location.DeleteLocationUserCase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteLocationController {
    private DeleteLocationUserCase userCase;

    public DeleteLocationController(DeleteLocationUserCase userCase) {
        this.userCase = userCase;
    }

    @DeleteMapping("/locations/{id}")
    public String deleteLocation(@PathVariable Long id){
        this.userCase.execute(id);
        return String.format("Location with id '%d' was deleted!%n", id);
    }

}
