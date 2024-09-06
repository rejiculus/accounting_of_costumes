package com.accounting_of_costumes.usercases.Tag;

import com.accounting_of_costumes.api.config.db.schema.ItemSchema;
import com.accounting_of_costumes.api.config.db.schema.TagSchema;
import com.accounting_of_costumes.entities.Tag.gateway.TagGateway;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import com.accounting_of_costumes.usercases.Tag.DTO.IAddTagData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CreateTagUserCaseTest {
    @Test
    public void createTagTest(){
        CreateTagUserCase userCase = new CreateTagUserCase(TestData.getTestDataInstance());
        userCase.execute(() -> "TestTeg");

        assertFalse(TestData.getTestDataInstance().findByName("TestTeg").isEmpty());

    }
}