package com.accounting_of_costumes.api.ItemState.Controller;

import com.accounting_of_costumes.api.ItemState.DTO.CreateItemStateData;
import com.accounting_of_costumes.usercases.ItemState.CreateItemStateUserCase;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateItemStateController {
    private CreateItemStateUserCase userCase;

    public CreateItemStateController(CreateItemStateUserCase userCase) {
        this.userCase = userCase;
    }

    @PutMapping("/itemStates")
    public String creteItemState(@RequestBody CreateItemStateData data){
        return this.userCase.execute(data).toString();
    }
}
