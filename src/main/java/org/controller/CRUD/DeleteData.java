package org.controller.CRUD;


import org.util.DButils;
import org.util.verify;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public String deleteStaffData(String staffId){
        try {
            //language=MySQL
            String sql = "delete from rs where id=?;";
            PreparedStatement preparedStatement = new DButils().getConnection().prepareStatement(sql);
            preparedStatement.setString(1,staffId);
            boolean execute = preparedStatement.execute();
            new verify(execute,"删除");
            new DButils().CloseConnection();
            return "删除成功";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteSomeData(){
        try {
            //language=MySQL
            String sql = "delete from user where userId=?";
            PreparedStatement preparedStatement = new DButils().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,2);
            boolean execute = preparedStatement.execute();
            new verify(execute,"删除");
            new DButils().CloseConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
