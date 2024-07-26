package com.accounting_of_costumes.api.config.db.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.accounting_of_costumes.api.config.db.schema.LocationSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting_of_costumes.api.config.db.schema.ItemSchema;

public interface ItemRepository extends JpaRepository<ItemSchema, Long> {
    List<ItemSchema> findByName(String name);
    List<ItemSchema> findByArticle(String article);
    Optional<ItemSchema> findByLocation(LocationSchema location);
    List<ItemSchema> findByRegistrationDate(LocalDate registrationDate);
    List<ItemSchema> findByWriteOffDate(LocalDate writeOffDate);
    List<ItemSchema> findBetweenRegistrationDate(LocalDate startDate,LocalDate endDate);
    List<ItemSchema> findBetweenWriteOffDate(LocalDate startDate,LocalDate endDate);
}
