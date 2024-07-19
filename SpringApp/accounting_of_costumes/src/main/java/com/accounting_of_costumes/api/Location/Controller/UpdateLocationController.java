package com.accounting_of_costumes.api.Location.Controller;

import com.accounting_of_costumes.api.Location.DTO.UpdateLocationData;
import com.accounting_of_costumes.usercases.Location.UpdateLocationUserCase;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateLocationController {
    private UpdateLocationUserCase userCase;

    public UpdateLocationController(UpdateLocationUserCase userCase) {
        this.userCase = userCase;
    }

    @PutMapping("/locations/{id}")
    public String updateLocation(@PathVariable Long id, @RequestBody UpdateLocationData data){
        if(id.equals(data.id()))    //todo correct this shit
            return this.userCase.execute(data).toString();
        return this.userCase.execute(new UpdateLocationData(id, data.route(), data.place())).toString();
    }
}
