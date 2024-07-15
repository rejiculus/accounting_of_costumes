package com.accounting_of_costumes.api.Tag.Controller;

import com.accounting_of_costumes.api.Tag.DTO.CreateTagData;
import com.accounting_of_costumes.api.Tag.DTO.TagPublicData;
import com.accounting_of_costumes.api.config.db.schema.TagSchema;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import com.accounting_of_costumes.usercases.Tag.GetAllTagsUserCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetAllTagsController {
    public final GetAllTagsUserCase userCase;

    public GetAllTagsController(GetAllTagsUserCase getAllTagsUserCase){
        this.userCase = getAllTagsUserCase;
    }

    @GetMapping("/tag/")
    @ResponseStatus(HttpStatus.OK)
    public String getAllTagsString(){
        List<Tag> tag = userCase.execute();
        return tag.stream()
                .map(TagPublicData::new)
                .toList()
                .toString();
    }

}
