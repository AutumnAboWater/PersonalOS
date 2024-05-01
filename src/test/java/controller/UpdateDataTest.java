package controller;

import controller.CRUD.UpdateData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UpdateDataTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void updateSomeData() {
        String updateSomeData = new UpdateData().UpdateSomeData();
        System.out.println(updateSomeData);
    }
}