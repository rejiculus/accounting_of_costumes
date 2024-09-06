package com.accounting_of_costumes.api.Tag.Controller;

import com.accounting_of_costumes.api.Tag.DTO.CreateTagData;
import com.accounting_of_costumes.api.Tag.DTO.TagPublicDTO;
import com.accounting_of_costumes.api.Tag.DTO.TagPublicData;
import com.accounting_of_costumes.api.Tag.DTO.TagsItemPublicDTO;
import com.accounting_of_costumes.api.config.db.schema.TagSchema;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import com.accounting_of_costumes.usercases.Tag.GetAllTagsUserCase;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GetAllTagsController {
    public final GetAllTagsUserCase userCase;

    public GetAllTagsController(GetAllTagsUserCase getAllTagsUserCase){
        this.userCase = getAllTagsUserCase;
    }

    @GetMapping("/tags")
    @ResponseStatus(HttpStatus.OK)
    public String getAllTagsString(Model model){
        List<Tag> tag = userCase.execute();
        List<TagPublicDTO> tags=  tag.stream()
                .map(TagPublicDTO::new)
                .toList();

        model.addAttribute("tags", tags)
                .addAttribute("allItemsPage","/items")
                .addAttribute("createTagPage", "/tags/create");
        return "tags/tags_list";
    }

}
