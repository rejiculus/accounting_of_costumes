package com.accounting_of_costumes.api.Location.Controller;

import com.accounting_of_costumes.usercases.Location.GetLocationByRouteUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetLocationByRouteController {
    private GetLocationByRouteUserCase userCase;

    public GetLocationByRouteController(GetLocationByRouteUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/locations/")
    public String getLocationByRoute(@RequestParam String route){
        return this.userCase.execute(route).toString();
    }
}
