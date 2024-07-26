package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.usercases.Item.GetItemByNameUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetItemByNameController {
    private GetItemByNameUserCase userCase;

    public GetItemByNameController(GetItemByNameUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/items/?name={name}")
    public String getItemByName(@PathVariable String name){
        return this.userCase.execute(name).toString();
    }
}
