package com.accounting_of_costumes.entities.Place.model;

import com.accounting_of_costumes.entities.Exception.NoValidNameException;
import com.accounting_of_costumes.entities.Exception.NullValueParamException;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Exception.NoValidIdException;

import java.util.HashSet;
import java.util.Set;

public class Place {
    private Long id;
    private String name;
    private Set<Location> locations;

    {
        locations=new HashSet<>();
    }

    public Place(String name) {
        this.name = name;
    }


    public Place(Long id, String name) {
        this.id = id;
        this.name = name;
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
        if(id<0)
            throw new NoValidIdException(id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null || name.isEmpty())
            throw new NoValidNameException(name);
        this.name = name;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        if(locations==null)
            throw new NullValueParamException("locations");
        this.locations = locations;
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
