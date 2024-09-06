package com.accounting_of_costumes.api.Tag.Controller;

import com.accounting_of_costumes.api.Tag.DTO.CreateTagDTO;
import com.accounting_of_costumes.api.Tag.DTO.CreateTagData;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import com.accounting_of_costumes.usercases.Tag.CreateTagUserCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CreateTagController {
    private final CreateTagUserCase userCase;

    public CreateTagController(CreateTagUserCase createTagUserCase){
        this.userCase = createTagUserCase;
    }

    @PostMapping("/tags")
    public String createTag(@ModelAttribute CreateTagDTO data){
        Tag tag = userCase.execute(new CreateTagData(data.getName()));//fixme change interface
        return "redirect:/tags/"+tag.getName();
    }

    @GetMapping("/tags/create")
    public String getCreationPage(Model model){
        model.addAttribute("tag", new CreateTagDTO())
                .addAttribute("allTagsPage", "/tags");
        return "tags/create_tag";
    }
}
