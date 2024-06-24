package com.accounting_of_costumes.usercases;

import com.accounting_of_costumes.entities.ItemState;
import com.accounting_of_costumes.entities.Operation;

import java.util.List;
import java.util.Optional;

public interface ItemStateRepository {
    //U update
    //C create
    ItemState save(ItemState itemState);

    //R read
    List<ItemState> findAll();
    Optional<ItemState> findByName(String name);

    //D delete
    void delete(ItemState itemState);
}
