package controller.CRUD;

import org.junit.jupiter.api.Test;

import java.util.HashMap;


class SelectDataTest {
    String StaffId;
    String StaffName;
    String staffAge;
    String StaffGender;
    String StaffNumber;
    String Staffedept;
    @Test
    void selectStaffData() {
        HashMap<String, String> stringHashMap = new SelectData().selectStaffData("张波");
             StaffId = stringHashMap.get("StaffId");
             StaffName = stringHashMap.get("StaffName");
              staffAge = stringHashMap.get("StaffAge");
             StaffGender = stringHashMap.get("StaffGender");
             StaffNumber = stringHashMap.get("StaffNumber");
             Staffedept = stringHashMap.get("Staffedept");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "SelectDataTest{" +
                "StaffId='" + StaffId + '\'' +
                ", StaffName='" + StaffName + '\'' +
                ", staffAge='" + staffAge + '\'' +
                ", StaffGender='" + StaffGender + '\'' +
                ", StaffNumber='" + StaffNumber + '\'' +
                ", Staffedept='" + Staffedept + '\'' +
                '}';
    }
}