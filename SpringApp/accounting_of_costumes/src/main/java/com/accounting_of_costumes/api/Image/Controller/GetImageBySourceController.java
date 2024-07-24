package com.accounting_of_costumes.api.Image.Controller;

import com.accounting_of_costumes.usercases.Image.GetImageBySourceUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetImageBySourceController {
    private GetImageBySourceUserCase userCase;

    public GetImageBySourceController(GetImageBySourceUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/images/?source={source}")
    public String getImageBySource(@PathVariable String source){
        return this.userCase.execute(source).toString();
    }
}
