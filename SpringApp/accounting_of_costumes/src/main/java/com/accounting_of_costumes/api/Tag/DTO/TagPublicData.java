package com.accounting_of_costumes.api.Tag.DTO;

import com.accounting_of_costumes.api.config.db.schema.ItemSchema;
import com.accounting_of_costumes.api.config.db.schema.TagSchema;
import com.accounting_of_costumes.usercases.Tag.DTO.ITagPublicData;

import java.util.Map;
import java.util.stream.Collectors;

public record TagPublicData(String name, Map<Long,String> items) implements ITagPublicData {
    public TagPublicData(TagSchema tag){
        this(
                tag.getName(),
                tag.getItems().stream()
                        .collect(Collectors.toMap(ItemSchema::getId, ItemSchema::getName))
            );

    }

}
