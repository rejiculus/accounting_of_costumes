package com.accounting_of_costumes.api.Tag.Controller;

import com.accounting_of_costumes.api.Tag.DTO.TagPublicDTO;
import com.accounting_of_costumes.api.Tag.DTO.TagPublicData;
import com.accounting_of_costumes.entities.Tag.exception.TagNotFoundException;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import com.accounting_of_costumes.usercases.Tag.GetTagUserCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GetTagController {
    private GetTagUserCase userCase;

    public GetTagController(GetTagUserCase getTagUserCase){
        this.userCase = getTagUserCase;
    }

    @GetMapping("/tags/{name}")
    public String getTag(@PathVariable String name, Model model) throws TagNotFoundException {
        Tag tag = userCase.execute(name);
        model.addAttribute("tag", new TagPublicDTO(tag))
                .addAttribute("allTagsPage", "/tags")
                .addAttribute("allItemsPage", "/items")
                .addAttribute("deleteTag", "/tags/"+name);
        return "tags/tag";
    }
}
