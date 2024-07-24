package com.accounting_of_costumes.api.Image.Controller;

import com.accounting_of_costumes.api.Image.DTO.UpdateImageData;
import com.accounting_of_costumes.usercases.Image.DTO.IUpdateImageData;
import com.accounting_of_costumes.usercases.Image.UpdateImageUserCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateImageController {
    private UpdateImageUserCase userCase;

    public UpdateImageController(UpdateImageUserCase userCase) {
        this.userCase = userCase;
    }

    @PutMapping("/images/{id}")
    public String updateImage(@PathVariable Long id, @RequestBody IUpdateImageData data){
        if(id.equals(data.id()))
            return this.userCase.execute(data).toString();
        else return this.userCase.execute(new UpdateImageData(id, data.source(), data.itemId())).toString();
    }
}
