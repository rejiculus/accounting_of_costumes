package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.usercases.Item.GetItemByIdUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetItemByIdController {
    private GetItemByIdUserCase userCase;

    public GetItemByIdController(GetItemByIdUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/items/{id}")
    public String getItemById(@PathVariable Long id){
        return this.userCase.execute(id).toString();
    }
}
