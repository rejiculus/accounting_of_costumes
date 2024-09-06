package com.accounting_of_costumes.api.Location.Controller;

import com.accounting_of_costumes.api.Location.DTO.GetLocationByPlaceData;
import com.accounting_of_costumes.api.Place.DTO.PlacePublicData;
import com.accounting_of_costumes.entities.Location.exception.LocationNotFoundException;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.usercases.Location.GetLocationByPlaceUserCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class GetLocationByPlaceController {
    private GetLocationByPlaceUserCase userCase;

    public GetLocationByPlaceController(GetLocationByPlaceUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping(value = "/locations/", params = "placeId")
    public String getLocationByPlace(@RequestParam Long placeId, Model model){

        model.addAttribute("all","/locations")
                .addAttribute("homepage", "/items");

        try{
            List<Location> location = this.userCase.execute(placeId);
            model.addAttribute("locations", location);
            return "locations/location";
        }catch (LocationNotFoundException e){
            System.out.println(e);
        }
        model.addAttribute("place", placeId);
        return "locations/location_not_found";
    }
}
