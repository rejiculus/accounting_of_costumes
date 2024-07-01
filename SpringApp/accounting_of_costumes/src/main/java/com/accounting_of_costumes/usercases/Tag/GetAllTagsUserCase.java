package com.accounting_of_costumes.usercases.Tag;

import com.accounting_of_costumes.entities.Tag.gateway.TagGateway;
import com.accounting_of_costumes.entities.Tag.model.Tag;

import java.util.List;

public class GetAllTagsUserCase {
    private final TagGateway gateway;

    public GetAllTagsUserCase(TagGateway TagGateway){
        this.gateway = TagGateway;
    }

    public List<Tag> execute() {
        return this.gateway.findAll();
    }
}
