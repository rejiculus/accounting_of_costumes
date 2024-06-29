package com.accounting_of_costumes.api.config.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting_of_costumes.api.config.db.schema.PersonSchema;

public interface PersonRepository extends JpaRepository<PersonSchema, Long>{
    List<PersonSchema> findAll();
    Optional<PersonSchema> findById(Long id);
    List<PersonSchema> findByLast_name(String last_name);
    List<PersonSchema> findByFirst_name(String first_name);
    

}
