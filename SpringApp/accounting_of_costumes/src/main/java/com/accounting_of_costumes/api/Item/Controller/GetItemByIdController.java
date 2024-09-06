package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.api.Item.DTO.ItemPublicData;
import com.accounting_of_costumes.api.Item.DTO.UpdateItemData;
import com.accounting_of_costumes.usercases.Item.GetItemByIdUserCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GetItemByIdController {
    private GetItemByIdUserCase userCase;

    public GetItemByIdController(GetItemByIdUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping(value = "/items",params = "id")
    public String getItemById(@RequestParam(value = "id") Long id, Model model){
        ItemPublicData itemDate = new ItemPublicData(this.userCase.execute(id));
        UpdateItemData updateItemData = new UpdateItemData();

        model.addAttribute("item", itemDate)
                .addAttribute("updateItem", updateItemData);
        
        return "items/item_page";

    }
}
