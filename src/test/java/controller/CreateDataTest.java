package controller;

import controller.CRUD.CreateData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateDataTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createSomeData() {
        new CreateData().createSomeData("1196105971@qq.com","Abcdefg1110");
    }
}