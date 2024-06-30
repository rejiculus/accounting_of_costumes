package com.accounting_of_costumes.entities.Tag.gateway;


import com.accounting_of_costumes.entities.Tag.model.Tag;

import java.util.List;
import java.util.Optional;

public interface ITagGateway {
    Tag create(Tag tag);
    Tag update(Tag tag);
    void delete(Tag tag);

    Optional<Tag> findByName(String name);

    List<Tag> findAll();
}
