package com.accounting_of_costumes.api.Place.Controller;

import com.accounting_of_costumes.entities.Place.exception.PlaceNotFoundException;
import com.accounting_of_costumes.entities.Place.model.Place;
import com.accounting_of_costumes.usercases.Place.GetPlaceByIdUserCase;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPlaceByIdController {
    private GetPlaceByIdUserCase userCase;

    public GetPlaceByIdController(GetPlaceByIdUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/places/{id}")
    public String getPlaceById(@PathVariable Long id, Model model){

        model.addAttribute("allPlaces","/places")
                .addAttribute("homepage", "/items");
        try{
            Place place = this.userCase.execute(id);
            model.addAttribute("place", place);
            return "places/place";
        }catch (PlaceNotFoundException e){
            System.out.println(e);
        }

         model.addAttribute("placeId", id);
         return "places/place_not_found";
    }
}
