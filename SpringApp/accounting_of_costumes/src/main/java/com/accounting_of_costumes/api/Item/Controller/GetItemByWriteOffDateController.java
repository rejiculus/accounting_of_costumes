package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.usercases.Item.GetItemByWriteOffDateUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class GetItemByWriteOffDateController {
    private GetItemByWriteOffDateUserCase userCase;

    public GetItemByWriteOffDateController(GetItemByWriteOffDateUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/items/?writeOffDate={date}")
    public String getItemByWriteOffDate(@PathVariable LocalDate date){
        return this.userCase.execute(date).toString();
    }
}
