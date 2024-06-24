package com.accounting_of_costumes.usercases;

import com.accounting_of_costumes.entities.Tag;

import java.util.List;
import java.util.Optional;

public interface TagRepository {
    //U update
    //C create
    Tag save(Tag tag);

    //R read
    List<Tag> findAll();
    Optional<Tag> findByName(String name);

    //D delete
    void delete(Tag tag);
}
