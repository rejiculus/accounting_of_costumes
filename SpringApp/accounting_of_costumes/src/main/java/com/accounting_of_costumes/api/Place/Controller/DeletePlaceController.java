package com.accounting_of_costumes.api.Place.Controller;

import com.accounting_of_costumes.entities.Place.exception.PlaceNotFoundException;
import com.accounting_of_costumes.usercases.Place.DeletePlaceUserCase;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeletePlaceController {
    private DeletePlaceUserCase userCase;

    public DeletePlaceController(DeletePlaceUserCase userCase) {
        this.userCase = userCase;
    }

    @PostMapping("/places/{id}")
    public String deletePlace(@PathVariable Long id, Model model){

        model.addAttribute("placeId", id)
                .addAttribute("allPlaces","/places")
                .addAttribute("homepage", "/items");

        try {//todo think how to improve it
            this.userCase.execute(id);
            return "places/place_deleted";
        } catch (PlaceNotFoundException e){
            System.out.println(e);//todo do log
        }

        return "places/place_not_found";
    }
}
