package com.accounting_of_costumes.api.config.db.repository;

import com.accounting_of_costumes.api.config.db.schema.ImageSchema;
import com.accounting_of_costumes.api.config.db.schema.ItemSchema;
import com.accounting_of_costumes.entities.Image.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageSchema, Long> {
    Optional<ImageSchema> findBySource(String source);
    List<ImageSchema> findByItem(ItemSchema item);
}
