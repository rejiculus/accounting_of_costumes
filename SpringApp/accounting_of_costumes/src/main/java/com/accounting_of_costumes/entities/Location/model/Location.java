package com.accounting_of_costumes.entities.Location.model;

import com.accounting_of_costumes.entities.Exception.NoValidIdException;
import com.accounting_of_costumes.entities.Exception.NullValueParamException;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.entities.Location.exception.NoValidRouteException;
import com.accounting_of_costumes.entities.Place.model.Place;

import java.util.HashSet;
import java.util.Set;

public class Location {
    private Long id;
    private String route;
    private Place place;
    private Set<Item> items;

    public Location(String route, Place place) {
        this.route = route;
        this.place = place;
        this.items = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id<0)
            throw new NoValidIdException(id);
        this.id = id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        if(route==null || route.isEmpty())
            throw new NoValidRouteException();
        this.route = route;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        if(place == null)
            throw new NullValueParamException("place");
        this.place=place;

    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        if(items == null)
            throw new NullValueParamException("items");
        this.items = items;
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
