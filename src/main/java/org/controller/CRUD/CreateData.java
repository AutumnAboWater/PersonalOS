package org.controller.CRUD;


import org.util.DButils;
import org.util.verify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateData {
    private final String REGISTER_SUCCESS_TOKEN = "注册成功";
    private final String REGISTER_ERROR_TOKEN = "两次密码不一样，请重新尝试";
    private final String CREATE_SUCCESS_TOKEN = "添加成功";
    private final String CREATE_ERROR_TOKEN = "添加成功";

    final Connection connection = new DButils().getConnection();
    public String RegisterCreateData(String userName,String userPassword,String userSurePassword){
        try {
            //language=MySQL
            String sql = "insert into user(userName, userPassword) VALUES (?,?)";
                if (!(userPassword.equals(userSurePassword))){
                    return REGISTER_ERROR_TOKEN;
                }else {
                    //执行注册
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,userName);
                    preparedStatement.setString(2,userPassword);
                    boolean execute = preparedStatement.execute();
                    new verify(execute, "注册");
                }
            new DButils().CloseConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return REGISTER_SUCCESS_TOKEN;
    }
    public String createStaffData(String staffId,String staffName,String staffAge,String staffGender,String staffNumber,String staffEdept){
        try {
            //language=MySQL
            String sql ="insert into rs(id, name, age, sex, number, edept) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,staffId);
            preparedStatement.setString(2,staffName);
            preparedStatement.setString(3,staffAge);
            preparedStatement.setString(4,staffGender);
            preparedStatement.setString(5,staffNumber);
            preparedStatement.setString(6,staffEdept);
            boolean execute = preparedStatement.execute();
            new verify(execute,"添加");
            return CREATE_SUCCESS_TOKEN;
        } catch (SQLException e) {
            return CREATE_ERROR_TOKEN;
        }
    }
    public void createSomeData(String userName,String userPassword){
        try {
            //language=MySQL
            String sql = "insert into user(userName, userPassword) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,userPassword);
            boolean execute = preparedStatement.execute();
            new verify(execute,"添加");
            new DButils().CloseConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
