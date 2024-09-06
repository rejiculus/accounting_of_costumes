package com.accounting_of_costumes.api.Location.Controller;

import com.accounting_of_costumes.entities.Place.exception.PlaceNotFoundException;
import com.accounting_of_costumes.usercases.Location.DeleteLocationUserCase;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DeleteLocationController {
    private DeleteLocationUserCase userCase;

    public DeleteLocationController(DeleteLocationUserCase userCase) {
        this.userCase = userCase;
    }

    @PostMapping("/locations/{id}")
    public String deleteLocation(@PathVariable Long id, Model model){

        model.addAttribute("id", id)
                .addAttribute("all","/locations")
                .addAttribute("homepage", "/items");

        try {//todo think how to improve it
            this.userCase.execute(id);
            return "locations/location_delete";
        } catch (PlaceNotFoundException e){
            System.out.println(e);//todo do log
        }
        return "locations/location_not_found";
    }

}
