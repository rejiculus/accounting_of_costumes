package com.accounting_of_costumes.api.Location.Gateway;

import com.accounting_of_costumes.api.config.db.repository.LocationRepository;
import com.accounting_of_costumes.api.config.db.schema.LocationSchema;
import com.accounting_of_costumes.api.config.db.schema.PlaceSchema;
import com.accounting_of_costumes.entities.Location.gateway.LocationGateway;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Place.model.Place;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LocationDatabaseGateway implements LocationGateway {
    private LocationRepository repository;

    public LocationDatabaseGateway(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Location create(Location location) {
        return this.repository.save(new LocationSchema(location)).toLocation();
    }

    @Override
    public Location update(Location location) {
        return this.repository.save(new LocationSchema(location)).toLocation();
    }

    @Override
    public void delete(Location location) {
        this.repository.delete(new LocationSchema(location));
    }

    @Override
    public Optional<Location> findByRoute(String route) {
        return this.repository.findByRoute(route)
                .map(LocationSchema::toLocation);
    }

    @Override
    public Optional<Location> findById(Long id) {
        return this.repository.findById(id)
                .map(LocationSchema::toLocation);
    }

    @Override
    public List<Location> findByPlace(Place place) {
        return this.repository.findByPlace(new PlaceSchema(place)).stream()
                .map(LocationSchema::toLocation)
                .collect(Collectors.toList());
    }

    @Override
    public List<Location> findAll() {
        return this.repository.findAll().stream()
                .map(LocationSchema::toLocation)
                .collect(Collectors.toList());
    }
}
