package com.accounting_of_costumes.usercases.Tag;

import com.accounting_of_costumes.api.config.db.schema.ItemSchema;
import com.accounting_of_costumes.api.config.db.schema.TagSchema;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.entities.ItemState.model.ItemState;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GetAllTagsUserCaseTest {
//    Set.of(
//                        new Item(0L,"name1",10,"no Article",null,new ItemState("Ready")),
//                        new Item(1L,"name1",10,"no Article",null,new ItemState("Ready"))
//                        )

    @Test
    void getAllTest() {
        TestData data = TestData.getTestDataInstance();
        List<Tag> exp = new ArrayList<>(List.of(
                new Tag("test 1"),
                new Tag("test 2"),
                new Tag("test 3"),
                new Tag("test 4"),
                new Tag("test 4")
        ));
        data.setTags(new HashSet<>(exp));
        GetAllTagsUserCase userCase = new GetAllTagsUserCase(data);

        List<Tag> tags = userCase.execute();
        assertTrue(tags.containsAll(exp));
    }
}