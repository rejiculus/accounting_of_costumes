package com.accounting_of_costumes.api.Location.Controller;

import com.accounting_of_costumes.api.Location.DTO.CreateLocationData;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.usercases.Location.CreateLocationUserCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CreateLocationController {
    private CreateLocationUserCase userCase;

    public CreateLocationController(CreateLocationUserCase userCase) {
        this.userCase = userCase;
    }
    @GetMapping("/locations/create")
    public String getCreatePage(Model model){
        model.addAttribute("all","/locations")
                .addAttribute("homepage", "/items")
                .addAttribute("location", new CreateLocationData("",-1L));
        return "/locations/location_create";
    }

    @PutMapping("/locations")
    public String createLocation(@RequestBody CreateLocationData data, Model model){
        Location location =this.userCase.execute(data);

        return "redirect:/locations/"+location.getId();
    }
}
