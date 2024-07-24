package com.accounting_of_costumes.api.config.db.repository;

import com.accounting_of_costumes.api.config.db.schema.LocationSchema;
import com.accounting_of_costumes.api.config.db.schema.PlaceSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<LocationSchema, Long> {
    Optional<LocationSchema> findByRoute(String route);
    List<LocationSchema> findByPlace(PlaceSchema place);
}
