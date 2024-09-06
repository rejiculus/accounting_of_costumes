package com.accounting_of_costumes.api.Location.Controller;

import com.accounting_of_costumes.api.Location.DTO.LocationPublicData;
import com.accounting_of_costumes.api.Place.DTO.LocationPublicDTO;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.usercases.Location.GetAllLocationsUserCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
public class GetAllLocationsController {
    private GetAllLocationsUserCase userCase;

    public GetAllLocationsController(GetAllLocationsUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/locations")
    public String getAllLocations(Model model){
        List<Location> locations = this.userCase.execute();
        List<LocationPublicData> pd = locations.stream()
                                .map(LocationPublicData::new)
                                .collect(Collectors.toList());

        model.addAttribute("locations",pd)
                .addAttribute("homepage","/items")
                .addAttribute("create", "/locations/create");

        return "locations/location_get_all";
    }
}
