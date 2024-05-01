package org.controller;


import org.controller.CRUD.SelectData;

public class LoginController {

    //登录逻辑
    public String Login(String userName,String  userPassword) {
        return new SelectData().loginSelectData(userName, userPassword);
    }
}
