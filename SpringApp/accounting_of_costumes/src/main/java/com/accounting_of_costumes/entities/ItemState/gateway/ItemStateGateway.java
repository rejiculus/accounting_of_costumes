package com.accounting_of_costumes.entities.ItemState.gateway;

import com.accounting_of_costumes.api.config.db.schema.ItemStateSchema;

import java.util.List;
import java.util.Optional;

public interface ItemStateGateway {
    ItemStateSchema create(ItemStateSchema itemState);
    ItemStateSchema update(ItemStateSchema itemStateSchema);
    void delete(ItemStateSchema itemStateSchema);

    Optional<ItemStateSchema> findByName(String name);

    List<ItemStateSchema> findAll();
}
