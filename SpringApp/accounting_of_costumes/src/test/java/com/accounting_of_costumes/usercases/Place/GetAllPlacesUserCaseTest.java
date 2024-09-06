package com.accounting_of_costumes.usercases.Place;

import com.accounting_of_costumes.entities.Place.model.Place;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GetAllPlacesUserCaseTest {
    @Test
    void getAllTest() {
        Set<Place> exp = Set.of(
                new Place(0L,"test1"),
                new Place(1L,"something"),
                new Place(2L,"Who?"),
                new Place(3L,"test42"),
                new Place(4L,"Aya sir")
        );
        TestData data = TestData.getTestDataInstance();
        data.setPlaces(new HashSet<>(exp));

        GetAllPlacesUserCase userCase = new GetAllPlacesUserCase(data);

        List<Place> res = userCase.execute();
        assertTrue(exp.containsAll(res));
    }
}