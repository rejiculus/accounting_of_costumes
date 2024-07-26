package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.api.Location.DTO.LocationPublicData;
import com.accounting_of_costumes.usercases.Item.GetItemByLocationUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetItemByLocationController {
    private GetItemByLocationUserCase userCase;

    public GetItemByLocationController(GetItemByLocationUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/items/?location")
    public String getItemByLocation(@RequestBody LocationPublicData data){
        return this.userCase.execute(data).toString();
    }
}
