package com.accounting_of_costumes.entities.Location.gateway;

import com.accounting_of_costumes.entities.Location.model.Location;

import java.util.List;
import java.util.Optional;

public interface ILocationGateway {
    Location create(Location location);
    Location update(Location location);
    void delete(Location location);

    Optional<Location> findByRoute(String route);
    Optional<Location> findById(Long id);

    List<Location> findAll();
}
