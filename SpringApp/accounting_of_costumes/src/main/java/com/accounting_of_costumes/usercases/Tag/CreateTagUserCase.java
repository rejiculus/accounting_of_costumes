package com.accounting_of_costumes.usercases.Tag;

import com.accounting_of_costumes.entities.Exception.ParamValueException;
import com.accounting_of_costumes.entities.Tag.gateway.TagGateway;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import com.accounting_of_costumes.usercases.Tag.DTO.IAddTagData;

public class CreateTagUserCase {
    private final TagGateway gateway;

    public CreateTagUserCase(TagGateway tagGateway){
        this.gateway = tagGateway;
    }

    public Tag execute(IAddTagData tagData){
        if(tagData.name() == null || tagData.name().isEmpty())
            throw new ParamValueException("Empty tag name!");

        Tag tag = new Tag(tagData.name());

        return gateway.create(tag);
    }
}
