package com.accounting_of_costumes.usercases.Place;

import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Place.model.Place;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CreatePlaceUserCaseTest {
    @Test
    void createPlaceTest() {
        TestData data = TestData.getTestDataInstance();
        Place exp = new Place(99L,"Test");
        exp.setLocations(Set.of(new Location("ABC",exp)));

        GetPlaceByIdUserCase find = new GetPlaceByIdUserCase(data);
        CreatePlaceUserCase userCase = new CreatePlaceUserCase(data);
        Place mid = userCase.execute(exp::getName);

        assertEquals(find.execute(mid.getId()).getName(),exp.getName());
    }
}