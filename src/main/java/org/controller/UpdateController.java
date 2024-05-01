package org.controller;

import org.controller.CRUD.UpdateData;

public class UpdateController {
    public String updateStaffData(String staffName,String staffAge,String staffGender,String staffNumber,String staffEdept,String staffId){
        return new UpdateData().UpdateStaffData(staffName,staffAge,staffGender,staffNumber,staffEdept,staffId);
    }
}
