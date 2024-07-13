package com.accounting_of_costumes.api.Tag.Controller;

import com.accounting_of_costumes.api.Tag.DTO.CreateTagData;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import com.accounting_of_costumes.usercases.Tag.CreateTagUserCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateTagController {
    private final CreateTagUserCase userCase;

    public CreateTagController(CreateTagUserCase createTagUserCase){
        this.userCase = createTagUserCase;
    }

    @PutMapping("/test/tag/")
    public String createTag(@RequestBody CreateTagData data){
        Tag tag = userCase.execute(data);
        return tag.toString();
    }
}
