package com.accounting_of_costumes.api.Image.Controller;

import com.accounting_of_costumes.usercases.Image.DeleteImageUserCase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteImageController {
    private DeleteImageUserCase userCase;

    public DeleteImageController(DeleteImageUserCase userCase) {
        this.userCase = userCase;
    }

    @DeleteMapping("/images/{id}")
    public String deleteImage(@PathVariable Long id){
        this.userCase.execute(id);
        return String.format("Image '%d' was deleted!", id);
    }
}
