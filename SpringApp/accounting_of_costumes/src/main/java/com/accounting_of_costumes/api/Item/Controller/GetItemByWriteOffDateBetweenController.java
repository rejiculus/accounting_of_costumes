package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.api.Item.DTO.GetItemBetweenDatesData;
import com.accounting_of_costumes.usercases.Item.GetItemByWriteOffDateBetweenUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetItemByWriteOffDateBetweenController {
    private GetItemByWriteOffDateBetweenUserCase userCase;

    public GetItemByWriteOffDateBetweenController(GetItemByWriteOffDateBetweenUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/items/?writeOffBetween")
    public String getItemByWriteOffDateBetween(@RequestBody GetItemBetweenDatesData data){
        return this.userCase.execute(data).toString();
    }
}
