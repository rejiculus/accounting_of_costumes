package com.accounting_of_costumes.api.Tag.DTO;

import com.accounting_of_costumes.api.config.db.schema.ItemSchema;
import com.accounting_of_costumes.api.config.db.schema.TagSchema;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import com.accounting_of_costumes.usercases.Tag.DTO.ITagPublicData;

import java.util.Map;
import java.util.stream.Collectors;

public record TagPublicData(String name, Map<Long,String> items) implements ITagPublicData {
    public TagPublicData(Tag tag){
        this(
                tag.getName(),
                tag.getItems().stream()
                        .collect(Collectors.toMap(Item::getId, Item::getName))
            );

    }

}
