package com.accounting_of_costumes.entities.Place.model;

import com.accounting_of_costumes.entities.Location.model.Location;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Place {
    private Long id;
    private String name;
    private Set<Location> locations;

    public Place(String name) {
        this.name = name;
        locations = new HashSet<>();
    }

    public Place(String name, Set<Location> locations) {
        this.name = name;
        this.locations = locations;
    }

    public Place(Long id, String name, Set<Location> locations) {
        this.id = id;
        this.name = name;
        this.locations = locations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    public void addLocation(Location location){
        this.locations.add(location);
    }

    public void deleteLocation(Location location){
        this.locations.remove(location);
    }

    private Set<Long> getLocationsIds(){
        return this.locations.stream()
                .map(Location::getId)
                .collect(Collectors.toSet());
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place place)) return false;

        return getId().equals(place.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
