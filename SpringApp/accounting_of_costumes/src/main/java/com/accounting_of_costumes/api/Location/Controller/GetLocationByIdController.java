package com.accounting_of_costumes.api.Location.Controller;

import com.accounting_of_costumes.entities.Location.exception.LocationNotFoundException;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Place.exception.PlaceNotFoundException;
import com.accounting_of_costumes.entities.Place.model.Place;
import com.accounting_of_costumes.usercases.Location.GetLocationByIdUserCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GetLocationByIdController {
    private GetLocationByIdUserCase userCase;

    public GetLocationByIdController(GetLocationByIdUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/locations/{id}")
    public String getLocationById(@PathVariable Long id, Model model){

        model.addAttribute("all","/locations")
                .addAttribute("homepage", "/items");

        try{
            Location location = this.userCase.execute(id);
            model.addAttribute("location", location);
            return "locations/location";
        }catch (LocationNotFoundException e){
            System.out.println(e);
        }
        model.addAttribute("id", id);
        return "locations/location_not_found";
    }
}
