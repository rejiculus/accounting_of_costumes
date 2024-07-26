package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.usercases.Item.GetItemByRegistrationDateUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class GetItemByRegistrationDateController {
    private GetItemByRegistrationDateUserCase userCase;

    public GetItemByRegistrationDateController(GetItemByRegistrationDateUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/items/?regDate={date}")
    public String getItemByRegistrationDate(@PathVariable LocalDate date){
        return this.userCase.execute(date).toString();
    }
}
