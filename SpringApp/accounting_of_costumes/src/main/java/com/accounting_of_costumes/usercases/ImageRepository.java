package com.accounting_of_costumes.usercases;

import com.accounting_of_costumes.entities.Image;

import java.util.List;
import java.util.Optional;

public interface ImageRepository {
    //U update
    //C create
    Image save(Image image);

    //R read
    List<Image> findAll();
    Optional<Image> findById(Long id);
    Optional<Image> findBySource(String source);

    //D delete
    void delete(Image image);
}
