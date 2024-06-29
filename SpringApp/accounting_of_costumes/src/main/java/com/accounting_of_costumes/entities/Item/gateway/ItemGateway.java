package com.accounting_of_costumes.entities.Item.gateway;

import com.accounting_of_costumes.api.config.db.schema.ItemSchema;

import java.util.List;

public interface ItemGateway {
    //U update
    //C create
    ItemSchema save(ItemSchema itemSchema);

    //R read
    List<ItemSchema> findAll();
    List<ItemSchema> findByName(String name);
    //todo find by article
    //todo find by id

    //D delete
    void delete(ItemSchema itemSchema);


}
