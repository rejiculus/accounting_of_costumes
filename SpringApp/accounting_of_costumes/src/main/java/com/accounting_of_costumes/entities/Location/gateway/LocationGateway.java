package com.accounting_of_costumes.entities.Location.gateway;

import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Place.model.Place;

import java.util.List;
import java.util.Optional;

public interface LocationGateway {
    Location create(Location location);
    Location update(Location location);
    void delete(Location location);

    Optional<Location> findByRoute(String route);
    Optional<Location> findById(Long id);
    List<Location> findByPlace(Place place);

    List<Location> findAll();
}
