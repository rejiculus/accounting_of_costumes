package com.accounting_of_costumes.api.Image.Gateway;

import com.accounting_of_costumes.api.config.db.repository.ImageRepository;
import com.accounting_of_costumes.api.config.db.schema.ImageSchema;
import com.accounting_of_costumes.api.config.db.schema.ItemSchema;
import com.accounting_of_costumes.entities.Image.gateway.ImageGateway;
import com.accounting_of_costumes.entities.Image.model.Image;
import com.accounting_of_costumes.entities.Item.model.Item;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ImageDatabaseGateway implements ImageGateway {
    private ImageRepository repository;

    public ImageDatabaseGateway(ImageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Image create(Image image) {
        return this.repository.save(new ImageSchema(image)).toImage();
    }

    @Override
    public Image update(Image image) {
        return this.repository.save(new ImageSchema(image)).toImage();
    }

    @Override
    public void delete(Image image) {
        this.repository.delete(new ImageSchema(image));
    }

    @Override
    public Optional<Image> findById(Long id) {
        return this.repository.findById(id)
                .map(ImageSchema::toImage);
    }

    @Override
    public Optional<Image> findBySource(String source) {
        return this.repository.findBySource(source)
                .map(ImageSchema::toImage);
    }

    @Override
    public List<Image> findByItem(Item item) {
        return this.repository.findByItem(new ItemSchema(item)).stream()
                .map(ImageSchema::toImage)
                .collect(Collectors.toList());
    }

    @Override
    public List<Image> findAll() {
        return this.repository.findAll().stream()
                .map(ImageSchema::toImage)
                .collect(Collectors.toList());
    }
}
