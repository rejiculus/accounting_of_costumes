package com.accounting_of_costumes.api.Item.Gateway;

import com.accounting_of_costumes.api.config.db.repository.ItemRepository;
import com.accounting_of_costumes.api.config.db.schema.ItemSchema;
import com.accounting_of_costumes.api.config.db.schema.LocationSchema;
import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.entities.Location.model.Location;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItemDatabaseGateway implements ItemGateway {
    private ItemRepository repository;

    public ItemDatabaseGateway(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Item create(Item item) {
        return this.repository.save(new ItemSchema(item))
                .toItem();
    }

    @Override
    public Item update(Item item) {
        return this.repository.save(new ItemSchema(item))
                .toItem();
    }

    @Override
    public void delete(Item item) {
        this.repository.delete(new ItemSchema(item));
    }

    @Override
    public Optional<Item> findById(Long id) {
        return this.repository.findById(id)
                .map(ItemSchema::toItem);
    }

    @Override
    public List<Item> findByName(String name) {
        return this.repository.findByName(name)
                .stream()
                .map(ItemSchema::toItem)
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> findByArticle(String article) {
        return this.repository.findByArticle(article)
                .stream()
                .map(ItemSchema::toItem)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findByLocation(Location location) {
        return this.repository.findByLocation(new LocationSchema(location))
                .map(ItemSchema::toItem);
    }

    @Override
    public List<Item> findByRegistrationDate(LocalDate registrationDate) {
        return this.repository.findByRegistrationDate(registrationDate)
                .stream()
                .map(ItemSchema::toItem)
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> findByWriteOffDate(LocalDate writeOffDate) {
        return this.repository.findByWriteOffDate(writeOffDate)
                .stream()
                .map(ItemSchema::toItem)
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> findRegistrationDateBetween(LocalDate startDate, LocalDate endDate) {
        return this.repository.findByRegistrationDateBetween(startDate,endDate)
                .stream()
                .map(ItemSchema::toItem)
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> findWriteOffDateBetween(LocalDate startDate, LocalDate endDate) {
        return this.repository.findByWriteOffDateBetween(startDate, endDate)
                .stream()
                .map(ItemSchema::toItem)
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> findAll() {
        return this.repository.findAll()
                .stream()
                .map(ItemSchema::toItem)
                .collect(Collectors.toList());
    }
}
