package org.controller.CRUD;



import org.util.DButils;
import org.util.verify;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class SelectData {
     final DButils dButils = new DButils();
     final Connection connection = dButils.getConnection();
    String LogInToken = null;

    final String MENU_SELECT_DATA_SUCCESS_TOKEN = "信息查询成功";
    final String MENU_SELECT_DATA_ERROR_TOKEN = "信息查询失败";
    final String SELECT_STAFF_SUCCESS_DATA_TOKEN = "查询成功";
    final String SELECT_STAFF_ERROR_DATA_TOKEN = "查询失败";
    public String loginSelectData(String inputUserName,String inputUserPassword){
        try {
            HashMap<String, String> stringHashMap = new HashMap<>();
            boolean userNameToken = false;
            boolean userPasswordToken = false;
            //language=MySQL
            String sql = "select *from user";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            //反馈信息
//            new verify(resultSet==null,"查询");
            if (resultSet != null) {
                while (resultSet.next()) {
                    String userName = resultSet.getString("userName");
                    String userPassword = resultSet.getString("userPassword");
                    stringHashMap.put(userName,userPassword);
                }
            }
            Set<Map.Entry<String, String>> entries = stringHashMap.entrySet();
            for (Map.Entry<String,String> entry:entries){
//                System.out.println(entry.getKey()+" "+entry.getValue());
                if (inputUserName.equals(entry.getKey())){
                        userNameToken = true;
                        if (inputUserPassword.equals((entry.getValue()))){
                            userPasswordToken = true;
                            break;
                        }
                }
            }
            if (userNameToken & userPasswordToken){
                System.out.println("登录成功!欢迎"+inputUserName);
                return LogInToken = "登录成功";
            }else if (!userNameToken){
                System.out.println("用户不存在");
                return LogInToken = "用户不存在";
            }else {
                System.out.println("密码错误");
                return LogInToken = "密码错误";
            }
//            stringHashMap.forEach((userName,userPassword)-> System.out.println("{userName:\t"+userName+"\tuserPassword:\t"+userPassword+"}"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            new DButils().CloseConnection();
        }
    }
    public HashMap<String,String>  selectStaffData(String id){
        String StaffId;
        String StaffName;
        String StaffAge;
        String StaffGender;
        String StaffNumber;
        String Staffedept;
        try {
            HashMap<String, String> stringHashMap = new HashMap<>();
            //language=MySQL
            String sql = "select *from rs where id = ?or name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            //反馈信息
            new verify(resultSet==null,"查询");
            if (resultSet != null) {
                while (resultSet.next()) {
                    //键值对
                     StaffId = resultSet.getString("id");
                     StaffName = resultSet.getString("name");
                     StaffAge = resultSet.getString("age");
                     StaffGender = resultSet.getString("sex");
                     StaffNumber = resultSet.getString("number");
                     Staffedept = resultSet.getString("edept");
                     stringHashMap.put("StaffId",StaffId);
                     stringHashMap.put("StaffName",StaffName);
                     stringHashMap.put("StaffAge",StaffAge);
                     stringHashMap.put("StaffGender",StaffGender);
                     stringHashMap.put("StaffNumber",StaffNumber);
                     stringHashMap.put("Staffedept",Staffedept);
                }
                //获取值
//                String hashMapStaffId = stringHashMap.get("StaffId");
//                System.out.println("hashMapStaffId:"+hashMapStaffId);
                //遍历
//                Set<Map.Entry<String, String>> entries = stringHashMap.entrySet();
//                for (Map.Entry<String,String> entry:entries){
//                    System.out.println(entry.getKey()+" "+entry.getValue());
//                }
                stringHashMap.put("message", SELECT_STAFF_SUCCESS_DATA_TOKEN);
                return stringHashMap;
            }
            else {
                stringHashMap.put("message",SELECT_STAFF_ERROR_DATA_TOKEN);
                return stringHashMap;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            dButils.CloseConnection();
        }
    }
    public String menuSelectData(DefaultTableModel tableModel) {
        //实例化Vector 使用动态数组存储
        //对于 Vector<String> columnNames = new Vector<>();
        // 这一句，Vector 用于存储表格的列名（字段名称），而字段名称是唯一的，
        // 适合用 Vector 或者更现代的 ArrayList 来存储。
        //
        //HashMap 是用于存储键值对的数据结构，它不适合用于存储一个有序的列名列表。
        // 因此，对于列名这种有序且唯一的情况，使用 Vector 或者 ArrayList 更为合适。
        //
        //如果你想要通过列名来快速查找对应的列数据，
        // 可以考虑使用 HashMap，但这与存储列名的需求不太一样。
        // 在这个场景下，使用 Vector<String> 或者 ArrayList<String> 更符合常见的做法，
        // 可以保持列名的顺序，方便在表格中使用。
        //language=MySQL
        String sql = "SELECT * FROM rs";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            // 获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // 获取列名，并设置为表格的列名
            String[] columnNames = {"员工编号", "员工姓名", "员工年龄", "员工性别", "员工手机号", "所属部门"};
            // 设置表格的列名
            tableModel.setColumnIdentifiers(columnNames);
            // 清空表格模型
            tableModel.setRowCount(0);
            // 遍历结果集中的每一行
            while (resultSet.next()) {
                Vector<Object> rowData = new Vector<>();
                // 遍历每一列
                for (int i = 1; i <= columnCount; i++) {
                    rowData.add(resultSet.getObject(i));
                }
                // 将一行数据添加到表格模型
                tableModel.addRow(rowData);
                // 如果有数据，显示表格，隐藏提示文本
            }
            return MENU_SELECT_DATA_SUCCESS_TOKEN;
        }catch (SQLException e) {
            return MENU_SELECT_DATA_ERROR_TOKEN;
        }
    }
    public void selectSomeData(){
        try {
            Connection connection = new DButils().getConnection();
            //language=MySQL
            String sql = "select *from user";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            //反馈信息
            new verify(resultSet==null,"查询");
            if (resultSet != null) {
                while (resultSet.next()) {
                    int userId = resultSet.getInt("userId");
                    String userName = resultSet.getString("userName");
                    String userPassword = resultSet.getString("userPassword");
                    System.out.println("{userId:"+userId+"\tuserName:"+userName+"\tuserPassword:"+userPassword+"}");
                }
            }
            dButils.CloseConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
