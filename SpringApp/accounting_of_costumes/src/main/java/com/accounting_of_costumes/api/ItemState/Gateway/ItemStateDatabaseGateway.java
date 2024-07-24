package com.accounting_of_costumes.api.ItemState.Gateway;

import com.accounting_of_costumes.api.config.db.repository.ItemStateRepository;
import com.accounting_of_costumes.api.config.db.schema.ItemStateSchema;
import com.accounting_of_costumes.entities.ItemState.gateway.ItemStateGateway;
import com.accounting_of_costumes.entities.ItemState.model.ItemState;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItemStateDatabaseGateway implements ItemStateGateway {
    private ItemStateRepository repository;

    public ItemStateDatabaseGateway(ItemStateRepository repository) {
        this.repository = repository;
    }

    @Override
    public ItemState create(ItemState itemState) {
        return this.repository.save(new ItemStateSchema(itemState)).toItemState();
    }

    @Override
    public ItemState update(ItemState itemState) {
        return this.repository.save(new ItemStateSchema(itemState)).toItemState();
    }

    @Override
    public void delete(ItemState itemState) {
        this.repository.delete(new ItemStateSchema(itemState));
    }

    @Override
    public Optional<ItemState> findByName(String name) {
        return this.repository.findById(name)
                .map(ItemStateSchema::toItemState);
    }

    @Override
    public List<ItemState> findAll() {
        return this.repository.findAll()
                .stream().map(ItemStateSchema::toItemState)
                .collect(Collectors.toList());
    }
}
