package com.accounting_of_costumes.api.config.db.repository;

import java.util.Optional;

import com.accounting_of_costumes.entities.Tag.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting_of_costumes.api.config.db.schema.TagSchema;

public interface TagRepository extends JpaRepository<TagSchema, String>{
    TagSchema findByName(String name);
}
