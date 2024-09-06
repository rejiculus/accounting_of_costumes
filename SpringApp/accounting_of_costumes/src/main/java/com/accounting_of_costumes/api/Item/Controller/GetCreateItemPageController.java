package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.api.Item.DTO.RequestItemData;
import com.accounting_of_costumes.entities.Image.model.Image;
import com.accounting_of_costumes.entities.ItemState.model.ItemState;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import com.accounting_of_costumes.usercases.Image.GetAllImagesUserCase;
import com.accounting_of_costumes.usercases.ItemState.GetAllItemStatesUserCase;
import com.accounting_of_costumes.usercases.Location.GetAllLocationsUserCase;
import com.accounting_of_costumes.usercases.Tag.GetAllTagsUserCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GetCreateItemPageController {
    private GetAllLocationsUserCase getAllLocationsUserCase;
    private GetAllItemStatesUserCase getAllItemStatesUserCase;
    private GetAllTagsUserCase getAllTagsUserCase;
    private GetAllImagesUserCase getAllImagesUserCase;

    public GetCreateItemPageController(GetAllLocationsUserCase getAllLocationsUserCase, GetAllItemStatesUserCase getAllItemStatesUserCase, GetAllTagsUserCase getAllTagsUserCase, GetAllImagesUserCase getAllImagesUserCase) {
        this.getAllLocationsUserCase = getAllLocationsUserCase;
        this.getAllItemStatesUserCase = getAllItemStatesUserCase;
        this.getAllTagsUserCase = getAllTagsUserCase;
        this.getAllImagesUserCase = getAllImagesUserCase;
    }


    @GetMapping("/items/create")
    public String createItemPage(Model model){
        List<Image> images = getAllImagesUserCase.execute();
        List<Location> locations = getAllLocationsUserCase.execute();
        List<ItemState> states = getAllItemStatesUserCase.execute();
        List<Tag> tags = getAllTagsUserCase.execute();

        RequestItemData data = new RequestItemData();
        model.addAttribute("item", data)
                .addAttribute("locations", locations)
                .addAttribute("states", states)
                .addAttribute("tags", tags)
                .addAttribute("images", images);

        return "items/create_item_page";
    }
}
