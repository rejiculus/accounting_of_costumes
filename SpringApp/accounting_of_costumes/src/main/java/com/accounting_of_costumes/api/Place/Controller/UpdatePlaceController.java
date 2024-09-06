package com.accounting_of_costumes.api.Place.Controller;

import com.accounting_of_costumes.api.Place.DTO.UpdatePlaceData;
import com.accounting_of_costumes.entities.Place.model.Place;
import com.accounting_of_costumes.usercases.Place.GetPlaceByIdUserCase;
import com.accounting_of_costumes.usercases.Place.UpdatePlaceUserCase;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdatePlaceController {
    private UpdatePlaceUserCase updatePlaceUserCase;
    private GetPlaceByIdUserCase getPlaceByIdUserCase;

    public UpdatePlaceController(UpdatePlaceUserCase updatePlaceUserCase, GetPlaceByIdUserCase getPlaceByIdUserCase) {
        this.updatePlaceUserCase = updatePlaceUserCase;
        this.getPlaceByIdUserCase = getPlaceByIdUserCase;
    }

    @GetMapping("/places/{id}/update")
    public String getUpdatePage(@PathVariable Long id, Model model){
        Place place = this.getPlaceByIdUserCase.execute(id);

        model.addAttribute("place", new UpdatePlaceData(place.getName()))
                .addAttribute("allPlaces", "/places")
                .addAttribute("homepage", "/places")
                .addAttribute("back", "/places/"+id);
        return "places/place_update";
    }
    @PutMapping("/places/{id}")
    public String updatePlace(@PathVariable Long id, @ModelAttribute UpdatePlaceData data){
        this.updatePlaceUserCase.execute(id, data);
        return "redirect:/places/"+id;
    }
}
