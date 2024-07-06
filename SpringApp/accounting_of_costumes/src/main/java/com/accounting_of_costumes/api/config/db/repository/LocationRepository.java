package com.accounting_of_costumes.api.config.db.repository;

import com.accounting_of_costumes.api.config.db.schema.LocationSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationSchema, Long> {
}
