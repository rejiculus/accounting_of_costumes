package com.accounting_of_costumes.entities.Image.gateway;

import com.accounting_of_costumes.api.config.db.schema.ImageSchema;

import java.util.List;
import java.util.Optional;

public interface ImageGateway {
    ImageSchema create(ImageSchema image);
    ImageSchema update(ImageSchema imageSchema);
    void delete(ImageSchema imageSchema);

    Optional<ImageSchema> findById(Long id);
    Optional<ImageSchema> findBySource(String source);

    List<ImageSchema> findAll();

}
