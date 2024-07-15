package com.accounting_of_costumes.api.Place.Gateway;

import com.accounting_of_costumes.api.config.db.repository.PlaceRepository;
import com.accounting_of_costumes.api.config.db.schema.PlaceSchema;
import com.accounting_of_costumes.entities.Place.gateway.PlaceGateway;
import com.accounting_of_costumes.entities.Place.model.Place;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlaceDatabaseGateway implements PlaceGateway {
    private final PlaceRepository repository;

    public PlaceDatabaseGateway(PlaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Place create(Place place) {
         return this.repository.save(new PlaceSchema(place)).toPlace();
    }

    @Override
    public Place update(Place place) {
        return this.repository.save(new PlaceSchema(place)).toPlace();
    }

    @Override
    public void delete(Place place) {
        this.repository.delete(new PlaceSchema(place));
    }

    @Override
    public Optional<Place> findByName(String name) {
        return this.repository.findByName(name)
                .map(PlaceSchema::toPlace);
    }

    @Override
    public Optional<Place> findById(Long id) {
        return this.repository.findById(id)
                .map(PlaceSchema::toPlace);
    }

    @Override
    public List<Place> findAll() {
        return this.repository.findAll()
                .stream()
                .map(PlaceSchema::toPlace)
                .collect(Collectors.toList());
    }
}
