package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.api.Item.DTO.UpdateItemData;
import com.accounting_of_costumes.usercases.Item.UpdateItemUserCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateItemController {
    private UpdateItemUserCase userCase;

    public UpdateItemController(UpdateItemUserCase userCase) {
        this.userCase = userCase;
    }

    @PutMapping("/items/{id}")
    public String updateItem(@PathVariable Long id, @RequestBody UpdateItemData data){
        if(id.equals(data.id()))
            return this.userCase.execute(data).toString();
        else
            return this.userCase.execute(new UpdateItemData(id,
                                                            data.name(),
                                                            data.count(),
                                                            data.article(),
                                                            data.registrationDate(),
                                                            data.writeOffDate(),
                                                            data.locationId(),
                                                            data.itemStateName(),
                                                            data.imageIds(),
                                                            data.tagNames()))
                    .toString();
    }
}
