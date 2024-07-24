package com.accounting_of_costumes.api.Image.Controller;

import com.accounting_of_costumes.usercases.Image.GetImageByItemUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetImageByItemController {
    private GetImageByItemUserCase userCase;

    public GetImageByItemController(GetImageByItemUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/images/?item={id}")
    public String getImageByItem(@PathVariable Long id){
        return this.userCase.execute(id).toString();
    }
}
