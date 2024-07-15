package com.accounting_of_costumes.api.Tag.Controller;

import com.accounting_of_costumes.api.Tag.DTO.TagPublicData;
import com.accounting_of_costumes.entities.Tag.exception.TagNotFoundException;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import com.accounting_of_costumes.usercases.Tag.GetTagUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetTagController {
    private GetTagUserCase userCase;

    public GetTagController(GetTagUserCase getTagUserCase){
        this.userCase = getTagUserCase;
    }

    @GetMapping(name = "/tag/{name}")
    public String getTag(@PathVariable String name) throws TagNotFoundException {
        Tag tag = userCase.execute(name);
        return new TagPublicData(tag).toString();
    }
}
