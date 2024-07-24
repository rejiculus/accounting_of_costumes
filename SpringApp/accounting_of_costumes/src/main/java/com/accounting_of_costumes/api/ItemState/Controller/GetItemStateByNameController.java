package com.accounting_of_costumes.api.ItemState.Controller;

import com.accounting_of_costumes.usercases.ItemState.GetItemStateByNameUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetItemStateByNameController {
    private GetItemStateByNameUserCase userCase;

    public GetItemStateByNameController(GetItemStateByNameUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/itemStates/{name}")
    public String getItemStateByName(@PathVariable String name){
        return this.userCase.execute(name).toString();
    }
}
