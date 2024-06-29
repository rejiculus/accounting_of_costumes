package com.accounting_of_costumes.entities.Tag.gateway;

import com.accounting_of_costumes.api.config.db.schema.TagSchema;

import java.util.List;
import java.util.Optional;

public interface TagGateway {
    TagSchema create(TagSchema tag);
    TagSchema update(TagSchema tag);
    void delete(TagSchema tagSchema);

    Optional<TagSchema> findByName(String name);

    List<TagSchema> findAll();
}
