package com.accounting_of_costumes.usercases.Tag;

import com.accounting_of_costumes.entities.Tag.model.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GetTagUserCaseTest {
    @Test
    void getTagTest() {
        TestData data = TestData.getTestDataInstance();
        List<Tag> exp = new ArrayList<>(List.of(
                new Tag("test 1"),
                new Tag("test 2"),
                new Tag("test 3"),
                new Tag("test 4"),
                new Tag("test 4")
        ));
        data.setTags(new HashSet<>(exp));
        GetTagUserCase userCase = new GetTagUserCase(data);

        Optional<Tag> res = TestData.getTestDataInstance().findByName(exp.get(1).getName());
        if(res.isEmpty())
            fail();
        assertEquals(res.get(), exp.get(1));
    }
}