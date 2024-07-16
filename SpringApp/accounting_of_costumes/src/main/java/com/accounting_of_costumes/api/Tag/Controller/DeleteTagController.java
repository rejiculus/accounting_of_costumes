package com.accounting_of_costumes.api.Tag.Controller;

import com.accounting_of_costumes.entities.Tag.exception.TagNotFoundException;
import com.accounting_of_costumes.usercases.Tag.DeleteTagUserCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;

@RestController
public class DeleteTagController {
    private DeleteTagUserCase userCase;

    public DeleteTagController(DeleteTagUserCase deleteTagUserCase){
        this.userCase = deleteTagUserCase;
    }

    @DeleteMapping("/tag/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteTag(@PathVariable String name) throws TagNotFoundException {
        this.userCase.execute(name);
        return String.format("Tag %s deleted!", name);
    }
}
