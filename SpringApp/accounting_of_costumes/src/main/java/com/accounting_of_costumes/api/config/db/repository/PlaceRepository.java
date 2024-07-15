package com.accounting_of_costumes.api.config.db.repository;

import com.accounting_of_costumes.api.config.db.schema.PlaceSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaceRepository extends JpaRepository<PlaceSchema, Long> {
    Optional<PlaceSchema> findByName(String name);
}
