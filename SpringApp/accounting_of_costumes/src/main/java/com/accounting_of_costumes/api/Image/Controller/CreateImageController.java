package com.accounting_of_costumes.api.Image.Controller;

import com.accounting_of_costumes.api.Image.DTO.CreateImageData;
import com.accounting_of_costumes.usercases.Image.CreateImageUserCase;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateImageController {
    private CreateImageUserCase userCase;

    public CreateImageController(CreateImageUserCase userCase) {
        this.userCase = userCase;
    }

    @PutMapping("/images")
    public String createImage(@RequestBody CreateImageData data){
        return this.userCase.execute(data).toString();
    }
}
