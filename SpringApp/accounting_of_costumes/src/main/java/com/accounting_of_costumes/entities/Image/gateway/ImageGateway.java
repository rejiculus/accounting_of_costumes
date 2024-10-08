package com.accounting_of_costumes.entities.Image.gateway;

import com.accounting_of_costumes.entities.Image.model.Image;
import com.accounting_of_costumes.entities.Item.model.Item;

import java.util.List;
import java.util.Optional;

public interface ImageGateway {
    Image create(Image image);
    Image update(Image image);
    void delete(Image image);

    Optional<Image> findById(Long id);
    Optional<Image> findBySource(String source);//todo удостовериться что поле unique
    List<Image> findByItem(Item item);

    List<Image> findAll();

}
