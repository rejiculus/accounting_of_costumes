package com.accounting_of_costumes.api.config.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting_of_costumes.api.config.db.schema.TagSchema;

public interface TagRepository extends JpaRepository<TagSchema, String>{
    
    
    Optional<TagSchema> findByName(String name);
}
