package com.accounting_of_costumes.api.Place.DTO;

import com.accounting_of_costumes.entities.Place.model.Place;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlacePublicDTO  {
    private Long id;
    private String name;
    private String url;
    private Set<LocationPublicDTO> locations;

    public PlacePublicDTO(Place place){
        this.id = place.getId();
        this.name = place.getName();
        this.url = "/places/"+id;
        this.locations = place.getLocations().stream()
                .map(LocationPublicDTO::new)
                .collect(Collectors.toSet());
    }


}
