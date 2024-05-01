package org.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButils {
    private static final String URL = "jdbc:mysql://sh-cynosdbmysql-grp-p18912d0.sql.tencentcdb.com:20056/PersonnelOS?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "Abcdefg1110";
    @FunctionalInterface
    private interface DatabaseConnectionHandler{
        Connection connection (String url,String userName,String userPassword) throws Exception;
    }
    private static final DatabaseConnectionHandler connectToDatabase =(url, userName, userPassword) -> {
        try {
            return DriverManager.getConnection(url,userName,userPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };
    private static  final DatabaseConnectionHandler connectionClose = (CloseUrl, RemoveUserName, RemoveUserPasswordToken) ->{
        Connection connection = DriverManager.getConnection(CloseUrl, RemoveUserName, RemoveUserPasswordToken);
        connection.close();
//        connection.prepareStatement(null).close();
        return null;
    };
    public Connection getConnection(){
        try {
            Connection connection = connectToDatabase.connection(URL, USER_NAME, USER_PASSWORD);
            if (connection!=null){
                System.out.println("🔗Success");
                return connection;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void CloseConnection(){
        try {
            connectionClose.connection(URL, USER_NAME, USER_PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
