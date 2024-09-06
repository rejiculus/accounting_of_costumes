package com.accounting_of_costumes.api.Place.Controller;

import com.accounting_of_costumes.entities.Place.exception.PlaceNotFoundException;
import com.accounting_of_costumes.entities.Place.model.Place;
import com.accounting_of_costumes.usercases.Place.GetPlaceByNameUserCase;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetPlaceByNameController {
    private GetPlaceByNameUserCase userCase;

    public GetPlaceByNameController(GetPlaceByNameUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping(value = "/places", params = "name")
    public String getPlaceByName(@RequestParam String name, Model model) {
        model.addAttribute("allPlaces", "/places")
                .addAttribute("homepage", "/items");
        try {
            Place place = this.userCase.execute(name); //todo я думаю он должен возвращать список
            model.addAttribute("place", place);
            return "places/place";
        } catch (
                PlaceNotFoundException e) {
            System.out.println(e);
        }

        model.addAttribute("placeId", name);//todo change attribute name
        return "places/place_not_found";


    }
}
