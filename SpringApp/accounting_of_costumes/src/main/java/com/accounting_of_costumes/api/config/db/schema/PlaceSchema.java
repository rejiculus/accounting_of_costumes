package com.accounting_of_costumes.api.config.db.schema;

import com.accounting_of_costumes.entities.Place.model.Place;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

import java.util.Set;

@Entity
@Table(name = "place")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "locations")
public class PlaceSchema {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "place")
    private Set<LocationSchema> locations;

    public PlaceSchema(Place place){
        this.id = place.getId();
        this.name = place.getName();
    }

    public Place toPlace(){
        return new Place(this.id, this.name);
    }
}
