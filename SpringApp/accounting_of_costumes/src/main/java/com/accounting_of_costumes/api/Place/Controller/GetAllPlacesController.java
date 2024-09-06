package com.accounting_of_costumes.api.Place.Controller;

import com.accounting_of_costumes.api.Place.DTO.PlacePublicDTO;
import com.accounting_of_costumes.entities.Place.model.Place;
import com.accounting_of_costumes.usercases.Place.GetAllPlacesUserCase;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllPlacesController {
    private GetAllPlacesUserCase userCase;

    public GetAllPlacesController(GetAllPlacesUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/places")
    public String GetAllPlaces(Model model){
        List<Place> places = this.userCase.execute();
        List<PlacePublicDTO> placesDTO = places.stream()
                .map(PlacePublicDTO::new)
                .toList();
        model.addAttribute("places",placesDTO)
                .addAttribute("homepage","/items")
                .addAttribute("createPlacePage", "/places/create");
        return "places/all_places";
    }
}
