package com.accounting_of_costumes.usercases;

import com.accounting_of_costumes.entities.Person;
import com.accounting_of_costumes.entities.Tag;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    //U update
    //C create
    Person save(Person person);

    //R read
    List<Person> findAll();
    Optional<Person> findById(Long id);
    //find by first name
    //find by last name


    //D delete
    void delete(Person person);
}
