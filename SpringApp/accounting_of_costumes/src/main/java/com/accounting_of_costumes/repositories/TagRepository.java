package com.accounting_of_costumes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting_of_costumes.models.Tag;

public interface TagRepository extends JpaRepository<Tag, String>{
    
    
    Optional<Tag> findByName(String name);
}
