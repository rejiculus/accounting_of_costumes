package com.accounting_of_costumes.usercases.Place;

import com.accounting_of_costumes.api.config.db.schema.PlaceSchema;
import com.accounting_of_costumes.entities.Place.gateway.PlaceGateway;
import com.accounting_of_costumes.entities.Place.model.Place;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TestData implements PlaceGateway {
    private static TestData instance;
    private Long count=0L;

    public static TestData getTestDataInstance(){
        if(instance==null)
            instance=new TestData();
        return instance;
    }
    private TestData(){}
    Set<PlaceSchema> places = new HashSet<>(Set.of(
            new PlaceSchema(new Place(0L,"test1")),
            new PlaceSchema(new Place(0L,"test1")))
    );

    public void setPlaces(Set<Place> places){
        this.places = places.stream()
                .map(PlaceSchema::new)
                .collect(Collectors.toSet());
    }

    public List<Place> getPlaceList(){
        return this.places.stream()
                .map(PlaceSchema::toPlace)
                .collect(Collectors.toList());
    }


    @Override
    public Place create(Place place) {
        place.setId(count++);
        PlaceSchema placeSchema = new PlaceSchema(place);
        places.add(placeSchema);
        return placeSchema.toPlace();
    }

    @Override
    public Place update(Place place) {
        PlaceSchema placeSchema = new PlaceSchema(place);
        places.add(placeSchema);
        return placeSchema.toPlace();
    }

    @Override
    public void delete(Place place) {
        PlaceSchema placeSchema = new PlaceSchema(place);
        places.remove(placeSchema);

    }

    @Override
    public Optional<Place> findByName(String name) {
        for(PlaceSchema place: places ){
            if(place.getName().equals(name))
                return Optional.of(place.toPlace());
        }
        return Optional.empty();
    }

    @Override
    public List<Place> findAll() {
        return places.stream()
                .map(PlaceSchema::toPlace)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Place> findById(Long id) {
        for(PlaceSchema place: places){
            if(place.getId().equals(id))
                return Optional.of(place.toPlace());
        }
        return Optional.empty();
    }
}

