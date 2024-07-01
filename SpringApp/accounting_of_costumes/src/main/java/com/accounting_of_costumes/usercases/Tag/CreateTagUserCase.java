package com.accounting_of_costumes.usercases.Tag;

import com.accounting_of_costumes.entities.Exception.ParamValueException;
import com.accounting_of_costumes.entities.Tag.gateway.TagGateway;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import com.accounting_of_costumes.usercases.Tag.DTO.IAddTagData;

public class CreateTagUserCase {
    private final TagGateway gateway;

    public CreateTagUserCase(TagGateway TagGateway){
        this.gateway = TagGateway;
    }

    public Tag execute(IAddTagData tagData){
        if(tagData.name() == null || tagData.name().isBlank())
            throw new ParamValueException("Empty tag name!");

        Tag tag = new Tag(tagData.name());

        return gateway.create(tag);
    }
}
