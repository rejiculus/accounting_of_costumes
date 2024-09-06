package com.accounting_of_costumes.usercases.Tag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteTagUserCaseTest {
    @Test
    void deleteTagTest() {
        final String testTagName = "TestTeg";
        CreateTagUserCase addUserCase = new CreateTagUserCase(TestData.getTestDataInstance());
        DeleteTagUserCase deleteTagUserCase = new DeleteTagUserCase(TestData.getTestDataInstance());

        addUserCase.execute(() -> testTagName);
        deleteTagUserCase.execute(testTagName);
        assertTrue(TestData.getTestDataInstance().findByName(testTagName).isEmpty());


    }
}