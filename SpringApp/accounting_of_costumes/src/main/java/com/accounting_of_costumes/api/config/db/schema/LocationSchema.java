package com.accounting_of_costumes.api.config.db.schema;

import com.accounting_of_costumes.entities.Location.model.Location;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "location")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class LocationSchema {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "route", nullable = false)
    private String route;

    @ManyToOne
    @JoinColumn(name = "place_fk", nullable = false)
    private PlaceSchema place;

    @OneToMany(mappedBy = "location")
    private Set<ItemSchema> items;

    public LocationSchema(Location location){
        this.id = location.getId();
        this.route = location.getRoute();
        this.place = new PlaceSchema(location.getPlace());
    }

    public Location toLocation(){
        Location location = new Location(this.route, this.place.toPlace());
        location.setId(this.id);
        return location;
    }
}
