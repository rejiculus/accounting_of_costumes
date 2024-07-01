package com.accounting_of_costumes.entities.ItemState.gateway;


import com.accounting_of_costumes.entities.ItemState.model.ItemState;

import java.util.List;
import java.util.Optional;

public interface ItemStateGateway {
    ItemState create(ItemState itemState);
    ItemState update(ItemState itemState);
    void delete(ItemState itemState);

    Optional<ItemState> findByName(String name);

    List<ItemState> findAll();
}
