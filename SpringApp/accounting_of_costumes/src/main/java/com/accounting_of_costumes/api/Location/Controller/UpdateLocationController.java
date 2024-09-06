package com.accounting_of_costumes.api.Location.Controller;

import com.accounting_of_costumes.api.Location.DTO.CreateLocationData;
import com.accounting_of_costumes.api.Location.DTO.UpdateLocationData;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Place.model.Place;
import com.accounting_of_costumes.usercases.Location.GetLocationByIdUserCase;
import com.accounting_of_costumes.usercases.Location.UpdateLocationUserCase;
import com.accounting_of_costumes.usercases.Place.GetAllPlacesUserCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UpdateLocationController {
    private UpdateLocationUserCase updateLocationUserCase;
    private GetLocationByIdUserCase getLocationByIdUserCase;
    private GetAllPlacesUserCase getAllPlacesUserCase;

    public UpdateLocationController(UpdateLocationUserCase updateLocationUserCase, GetLocationByIdUserCase getLocationByIdUserCase, GetAllPlacesUserCase getAllPlacesUserCase) {
        this.updateLocationUserCase = updateLocationUserCase;
        this.getLocationByIdUserCase = getLocationByIdUserCase;
        this.getAllPlacesUserCase = getAllPlacesUserCase;
    }

    @GetMapping("/locations/{id}/update")
    public String getCreatePage(@PathVariable Long id, Model model){
        Location location = this.getLocationByIdUserCase.execute(id);
        List<Place> places = this.getAllPlacesUserCase.execute();

        model.addAttribute("all","/locations")
                .addAttribute("homepage", "/items")
                .addAttribute("location", new UpdateLocationData(location))
                .addAttribute("places", places)
                .addAttribute("back", "/places/"+id);
        return "/locations/location_update";
    }

    @PutMapping("/locations/{id}")
    public String updateLocation(@PathVariable Long id, @RequestBody UpdateLocationData data){
        Location location;
        if(id.equals(data.id()))    //todo correct this shit
            location = this.updateLocationUserCase.execute(data);
        else
            location = this.updateLocationUserCase.execute(new UpdateLocationData(id, data.route(), data.placeId()));

        return "redirect:/locations/"+location.getId();
    }
}
