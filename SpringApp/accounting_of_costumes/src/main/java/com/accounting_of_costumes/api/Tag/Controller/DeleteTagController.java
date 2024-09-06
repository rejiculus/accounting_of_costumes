package com.accounting_of_costumes.api.Tag.Controller;

import com.accounting_of_costumes.entities.Tag.exception.TagNotFoundException;
import com.accounting_of_costumes.usercases.Tag.DeleteTagUserCase;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;

@Controller
public class DeleteTagController {
    private DeleteTagUserCase userCase;

    public DeleteTagController(DeleteTagUserCase deleteTagUserCase){
        this.userCase = deleteTagUserCase;
    }

    @PostMapping("/tags/{name}/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteTag(@PathVariable String name, Model model) throws TagNotFoundException {
        this.userCase.execute(name);
        model.addAttribute("name", name)
                .addAttribute("allTagsPage", "/tags")
                .addAttribute("allItemsPage", "/items");
        return "tags/tag_delete";
    }
}
