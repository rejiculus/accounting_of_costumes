package com.accounting_of_costumes.usercases.Tag;

import com.accounting_of_costumes.entities.Tag.exception.TagNotFoundException;
import com.accounting_of_costumes.entities.Tag.gateway.TagGateway;
import com.accounting_of_costumes.entities.Tag.model.Tag;

public class DeleteTagUserCase {
    private final TagGateway gateway;

    public DeleteTagUserCase(TagGateway tagGateway){
        this.gateway = tagGateway;
    }

    public void execute(String name) {
        Tag tag = this.gateway
                .findByName(name)
                .orElseThrow(() -> new TagNotFoundException(name));

        this.gateway.delete(tag);
    }
}
