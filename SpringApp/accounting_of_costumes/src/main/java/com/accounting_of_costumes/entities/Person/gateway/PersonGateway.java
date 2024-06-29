package com.accounting_of_costumes.entities.Person.gateway;

import com.accounting_of_costumes.api.config.db.schema.PersonSchema;

import java.util.List;
import java.util.Optional;

public interface PersonGateway {
    PersonSchema create(PersonSchema person);
    PersonSchema update(PersonSchema personSchema);
    void delete(PersonSchema personSchema);

    Optional<PersonSchema> findById(Long id);

    List<PersonSchema> findAll();
}
