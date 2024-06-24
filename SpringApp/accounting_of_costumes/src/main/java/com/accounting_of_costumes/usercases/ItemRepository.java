package com.accounting_of_costumes.usercases;

import com.accounting_of_costumes.entities.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    //U update
    //C create
    Item save(Item item);

    //R read
    List<Item> findAll();
    List<Item> findByName(String name);
    //todo find by article
    //todo find by id

    //D delete
    void delete(Item item);


}
