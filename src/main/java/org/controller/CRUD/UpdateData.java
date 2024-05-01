package org.controller.CRUD;

import org.util.DButils;
import org.util.verify;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {

    final private String UPDATE_STAFF_DATA_SUCCESS_TOKEN = "修改成功";
    final private String UPDATE_STAFF_DATA_ERROR_TOKEN = "修改失败";
    public String UpdateSomeData() {
        try {
            //language=MySQL
            String sql = "update user set userName=?,userPassword=? where userId=?";
            PreparedStatement preparedStatement = new DButils().getConnection().prepareStatement(sql);
            preparedStatement.setString(1,"adminer");
            preparedStatement.setString(2,"adminer");
            preparedStatement.setInt(3,1);
            boolean execute = preparedStatement.execute();
            new verify(execute,"修改");
            new DButils().CloseConnection();
            return UPDATE_STAFF_DATA_SUCCESS_TOKEN;
        } catch (SQLException e) {
            return UPDATE_STAFF_DATA_ERROR_TOKEN;
        }
    }
    public String UpdateStaffData(String staffName,String staffAge,String staffGender,String staffNumber,String staffEdept,String staffId){

        try {
            //language=MySQL
            String sql = "update rs set name=?,age=?,sex=?,number=?,edept=? where id=? or name=?";
            PreparedStatement preparedStatement = new DButils().getConnection().prepareStatement(sql);
            preparedStatement.setString(1,staffName);
            preparedStatement.setString(2,staffAge);
            preparedStatement.setString(3,staffGender);
            preparedStatement.setString(4,staffNumber);
            preparedStatement.setString(5,staffEdept);
            preparedStatement.setString(6,staffId);
            preparedStatement.setString(7,staffName);
            boolean execute = preparedStatement.execute();
            new verify(execute,"修改");
            new DButils().CloseConnection();
            return UPDATE_STAFF_DATA_SUCCESS_TOKEN;
        } catch (SQLException e) {
            return UPDATE_STAFF_DATA_ERROR_TOKEN;
        }
    }
}
