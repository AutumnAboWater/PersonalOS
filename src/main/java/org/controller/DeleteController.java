package org.controller;

import org.controller.CRUD.DeleteData;

public class DeleteController {
    //删除
    public String deleteStaffData(String staffId){
        return new DeleteData().deleteStaffData(staffId);
    }
}
