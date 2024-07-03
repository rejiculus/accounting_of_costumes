package com.accounting_of_costumes.usercases.Location;

import com.accounting_of_costumes.entities.Location.exception.LocationNotFoundException;
import com.accounting_of_costumes.entities.Location.gateway.LocationGateway;
import com.accounting_of_costumes.entities.Location.model.Location;

public class DeleteLocationUserCase {
    private LocationGateway locationGateway;

    public DeleteLocationUserCase(LocationGateway locationGateway){
        this.locationGateway = locationGateway;
    }

    public void execute(Long id){
        Location location = this.locationGateway.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));

        this.locationGateway.delete(location);
    }
}
