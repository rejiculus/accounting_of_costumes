package com.accounting_of_costumes.entities.Place.gateway;

import com.accounting_of_costumes.entities.Place.model.Place;

import java.util.List;
import java.util.Optional;

public interface IPlaceGateway {
    Place create(Place place);
    Place update(Place place);
    void delete(Place place);

    Optional<Place> findByName(String name);
    Optional<Place> findById(Long id);

    List<Place> findAll();
}
