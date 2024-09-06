package com.accounting_of_costumes.api.Tag.DTO;

import com.accounting_of_costumes.entities.Item.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagsItemPublicDTO {
    private String name;
    private String path;

    public TagsItemPublicDTO(Item item){
        this.name = item.getName();
        this.path = "/items?id="+item.getId();
    }
}
