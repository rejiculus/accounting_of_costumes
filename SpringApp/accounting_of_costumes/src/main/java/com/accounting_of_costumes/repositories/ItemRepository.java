package com.accounting_of_costumes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting_of_costumes.models.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
    List<Item> findByName(String name); 


}
