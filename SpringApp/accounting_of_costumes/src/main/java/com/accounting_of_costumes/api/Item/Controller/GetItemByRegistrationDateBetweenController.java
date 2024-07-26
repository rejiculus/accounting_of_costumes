package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.api.Item.DTO.GetItemBetweenDatesData;
import com.accounting_of_costumes.usercases.Item.GetItemByRegistrationDateBetweenUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetItemByRegistrationDateBetweenController {
    private GetItemByRegistrationDateBetweenUserCase userCase;

    public GetItemByRegistrationDateBetweenController(GetItemByRegistrationDateBetweenUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/items/?regBetween")
    public String GetItemBetweenRegistrationDates(@RequestBody GetItemBetweenDatesData data){
        return this.userCase.execute(data).toString();
    }
}
