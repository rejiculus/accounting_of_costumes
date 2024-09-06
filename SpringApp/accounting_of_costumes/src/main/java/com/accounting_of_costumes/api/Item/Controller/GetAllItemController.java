package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.api.Item.DTO.ItemPublicData;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.usercases.Item.GetAllItemUserCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GetAllItemController  {
    private GetAllItemUserCase userCase;

    public GetAllItemController(GetAllItemUserCase userCase) throws Throwable {
        this.userCase = userCase;
    }

    @GetMapping("/items")
    public String getAllItems(Model model){
        model.addAllAttributes(Map.of("some", "Hello"));

        List<ItemPublicData> items = this.userCase.execute().stream()
                .map(ItemPublicData::new)
                .toList();

        model.addAttribute("items", items)
                .addAttribute("allLocationsPage","/locations")
                .addAttribute("allTagsPage","/tags")
                .addAttribute("allPlacesPage","/places")
                .addAttribute("allStatesPage","/states")
                .addAttribute("allImagesPage","/images");

        return "items/All_Items_Page";
    }
}
