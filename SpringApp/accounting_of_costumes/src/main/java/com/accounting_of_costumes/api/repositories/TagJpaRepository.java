package com.accounting_of_costumes.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting_of_costumes.entities.Tag;

public interface TagJpaRepository extends JpaRepository<Tag, String>{
    
    
    Optional<Tag> findByName(String name);
}
