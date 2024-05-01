package controller;

import controller.CRUD.SelectData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SelectDataTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void selectSomeData() {
        new SelectData().selectSomeData();
        String s = new SelectData().loginSelectData("adminer", "adminer");
        System.out.println(s);
    }
}