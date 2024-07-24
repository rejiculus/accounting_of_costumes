package com.accounting_of_costumes.api.Image.Controller;

import com.accounting_of_costumes.usercases.Image.GetImageByIdUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetImageByIdController {
    private GetImageByIdUserCase userCase;

    public GetImageByIdController(GetImageByIdUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/images/{id}")
    public String getImageById(@PathVariable Long id){
        return this.userCase.execute(id).toString();
    }
}
