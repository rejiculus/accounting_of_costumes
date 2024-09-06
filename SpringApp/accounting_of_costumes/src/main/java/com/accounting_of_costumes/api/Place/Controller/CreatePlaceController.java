package com.accounting_of_costumes.api.Place.Controller;

import com.accounting_of_costumes.api.Place.DTO.CreatePlaceData;
import com.accounting_of_costumes.entities.Place.model.Place;
import com.accounting_of_costumes.usercases.Place.CreatePlaceUserCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CreatePlaceController {
    private CreatePlaceUserCase userCase;

    public CreatePlaceController(CreatePlaceUserCase userCase) {
        this.userCase = userCase;
    }

    @PutMapping({"/places","/places/"})
    public String createPlace(@ModelAttribute CreatePlaceData data){
        Place place = this.userCase.execute(data);
        return "redirect:/places/"+place.getId();
    }

    @GetMapping("/places/create")
    public String getCreatePlacePage(Model model){
        model.addAttribute("place", new CreatePlaceData(""))
                .addAttribute("allPlaces","/places")
                .addAttribute("homepage", "/items");
        return "places/place_create";

    }
}
