package com.accounting_of_costumes.api.Place.DTO;

import com.accounting_of_costumes.entities.Location.model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationPublicDTO {
    private Long id;
    private String route;
    private String url;

    public LocationPublicDTO(Location location){
        this.id = location.getId();
        this.route = location.getRoute();
        this.url = "/locations/"+id;
    }
}
