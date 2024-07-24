package com.accounting_of_costumes.api.ItemState.Controller;

import com.accounting_of_costumes.usercases.ItemState.DeleteItemStateUserCase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteItemStateController {
    private DeleteItemStateUserCase userCase;

    public DeleteItemStateController(DeleteItemStateUserCase userCase) {
        this.userCase = userCase;
    }

    @DeleteMapping("/itemStates/{name}")
    public String deleteItemState(@PathVariable String name){
        this.userCase.execute(name);
        return String.format("ItemState %s was deleted!", name);
    }
}
