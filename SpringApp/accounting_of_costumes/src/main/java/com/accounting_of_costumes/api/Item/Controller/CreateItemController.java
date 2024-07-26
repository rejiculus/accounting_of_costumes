package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.api.Item.DTO.CreateItemData;
import com.accounting_of_costumes.usercases.Item.CreateItemUserCase;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateItemController {
    private CreateItemUserCase userCase;

    public CreateItemController(CreateItemUserCase userCase) {
        this.userCase = userCase;
    }

    @PutMapping("/items")
    public String createItem(@RequestBody CreateItemData data){
        return this.userCase.execute(data).toString();
    }
}
