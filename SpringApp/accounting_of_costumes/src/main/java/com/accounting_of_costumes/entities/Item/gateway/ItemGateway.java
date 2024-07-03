package com.accounting_of_costumes.entities.Item.gateway;



import com.accounting_of_costumes.api.config.db.schema.TagSchema;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.entities.Location.model.Location;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ItemGateway {
    Item create(Item item);
    Item update(Item item);
    void delete(Item item);

    Optional<Item> findById(Long id);
    List<Item> findByName(String name);
    List<Item> findByArticle(String article);
    Optional<Item> findByLocation(Location location);
    List<Item> findByRegistrationDate(LocalDate registrationDate);
    List<Item> findByWriteOffDate(LocalDate writeOffDate);
    List<Item> findBetweenRegistrationDate(LocalDate startDate, LocalDate endDate);
    List<Item> findBetweenWriteOffDate(LocalDate startDate, LocalDate endDate);

    List<Item> findAll();
}
