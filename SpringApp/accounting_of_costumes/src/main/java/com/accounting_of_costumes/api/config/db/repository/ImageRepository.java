package com.accounting_of_costumes.api.config.db.repository;

import com.accounting_of_costumes.api.config.db.schema.ImageSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageSchema, Long> {
}
