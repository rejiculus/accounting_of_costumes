package com.accounting_of_costumes.api.Tag.DTO;

import com.accounting_of_costumes.api.config.db.schema.TagSchema;
import com.accounting_of_costumes.usercases.Tag.DTO.IAddTagData;

public record CreateTagData(
        String name
) implements IAddTagData { }
