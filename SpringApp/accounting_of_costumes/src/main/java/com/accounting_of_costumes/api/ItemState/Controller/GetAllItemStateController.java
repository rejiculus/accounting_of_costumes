package com.accounting_of_costumes.api.ItemState.Controller;

import com.accounting_of_costumes.usercases.ItemState.GetAllItemStatesUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAllItemStateController {
    private GetAllItemStatesUserCase userCase;

    public GetAllItemStateController(GetAllItemStatesUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/itemStates")
    public String getAllItemStates(){
        return this.userCase.execute().toString();
    }
}
