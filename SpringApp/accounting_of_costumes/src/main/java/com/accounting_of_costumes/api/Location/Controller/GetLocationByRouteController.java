package com.accounting_of_costumes.api.Location.Controller;

import com.accounting_of_costumes.entities.Location.exception.LocationNotFoundException;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.usercases.Location.GetLocationByRouteUserCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class GetLocationByRouteController {
    private GetLocationByRouteUserCase userCase;

    public GetLocationByRouteController(GetLocationByRouteUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping(value = "/locations/",params = "route")
    public String getLocationByRoute(@RequestParam String route, Model model){

        model.addAttribute("all","/locations")
                .addAttribute("homepage", "/items");

        try{
            Location location = this.userCase.execute(route);
            model.addAttribute("location", location);
            return "locations/location";
        }catch (LocationNotFoundException e){
            System.out.println(e);
        }
        model.addAttribute("route", route);
        return "locations/location_not_found";
    }
}
