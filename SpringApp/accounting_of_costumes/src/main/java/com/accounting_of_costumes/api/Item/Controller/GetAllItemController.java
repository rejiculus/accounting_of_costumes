package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.usercases.Item.GetAllItemUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAllItemController {
    private GetAllItemUserCase userCase;

    public GetAllItemController(GetAllItemUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/items")
    public String getAllItems(){
        return this.userCase.execute().toString();
    }
}
