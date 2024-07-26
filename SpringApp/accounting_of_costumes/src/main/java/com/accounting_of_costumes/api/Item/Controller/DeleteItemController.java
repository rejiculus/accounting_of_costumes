package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.usercases.Item.DeleteItemUserCase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteItemController {
    private DeleteItemUserCase userCase;

    public DeleteItemController(DeleteItemUserCase userCase) {
        this.userCase = userCase;
    }

    @DeleteMapping("/items/{id}")
    public String deleteItem(@PathVariable Long id){
        this.userCase.execute(id);
        return String.format("Item '%d' was deleted!",id);
    }
}
