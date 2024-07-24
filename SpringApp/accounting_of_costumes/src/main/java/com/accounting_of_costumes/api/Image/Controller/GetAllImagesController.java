package com.accounting_of_costumes.api.Image.Controller;

import com.accounting_of_costumes.usercases.Image.GetAllImagesUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAllImagesController {
    private GetAllImagesUserCase userCase;

    public GetAllImagesController(GetAllImagesUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/images")
    public String getAllImages(){
        return this.userCase.execute().toString();
    }
}
