package com.accounting_of_costumes.usercases.Tag;

import com.accounting_of_costumes.entities.Tag.exception.TagNotFoundException;
import com.accounting_of_costumes.entities.Tag.gateway.TagGateway;
import com.accounting_of_costumes.entities.Tag.model.Tag;

import java.util.List;

public class GetTagUserCase {
    private final TagGateway gateway;

    public GetTagUserCase(TagGateway TagGateway){
        this.gateway = TagGateway;
    }

    public Tag execute(String name) {
        return this.gateway
                    .findByName(name)
                    .orElseThrow(() -> new TagNotFoundException(name));
    }
}
