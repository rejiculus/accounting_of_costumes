package com.accounting_of_costumes.api.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting_of_costumes.entities.Item;

import com.accounting_of_costumes.usercases.ItemRepository;

public interface ItemJpaRepository extends JpaRepository<Item, Integer> {
    List<Item> findByName(String name);


}
