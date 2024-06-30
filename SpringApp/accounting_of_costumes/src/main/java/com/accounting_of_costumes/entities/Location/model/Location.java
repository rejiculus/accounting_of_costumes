package com.accounting_of_costumes.entities.Location.model;

import com.accounting_of_costumes.entities.Place.model.Place;

public class Location {
    private Long id;
    private String route;
    private Place place;

    public Location(String route, Place place) {
        this.route = route;
        this.place = place;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;

        return getId().equals(location.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }


    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", route='" + route + '\'' +
                ", place=" + place.getName() +
                '}';
    }
}
