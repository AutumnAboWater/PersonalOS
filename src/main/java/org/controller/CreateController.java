package org.controller;


import org.controller.CRUD.CreateData;

public class CreateController {
    public String createStaffDataController(String staffId,String staffName,String staffAge,String staffGender,String staffNumber,String staffEdept){
        return new CreateData().createStaffData(staffId,staffName,staffAge,staffGender,staffNumber,staffEdept);
    }
}
