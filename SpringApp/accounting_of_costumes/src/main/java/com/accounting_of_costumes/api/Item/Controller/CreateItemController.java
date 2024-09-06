package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.api.Item.DTO.CreateItemData;
import com.accounting_of_costumes.api.Item.DTO.RequestItemData;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.usercases.Image.GetAllImagesUserCase;
import com.accounting_of_costumes.usercases.Item.CreateItemUserCase;
import com.accounting_of_costumes.usercases.ItemState.GetAllItemStatesUserCase;
import com.accounting_of_costumes.usercases.Location.GetAllLocationsUserCase;
import com.accounting_of_costumes.usercases.Tag.GetAllTagsUserCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@Controller
public class CreateItemController {
    private final CreateItemUserCase createItemUserCase;

    public CreateItemController(CreateItemUserCase createItemUserCase) {
        this.createItemUserCase = createItemUserCase;
    }

    @PostMapping("/items")
    public String createItem(@ModelAttribute RequestItemData data, Model model){
        CreateItemData createData = new CreateItemData(data.getName(),
                data.getCount(),
                data.getArticle(),
                data.getRegistrationDate(),
                data.getWriteOffDate(),
                data.getLocationId(),
                data.getItemStateName(),
                new HashSet<>(),
                new HashSet<>());
        Item item = createItemUserCase.execute(createData);
        model.addAttribute("item", item);
        return "items/item_page";
    }

}
