package org.controller;



import org.controller.CRUD.CreateData;

import java.util.Scanner;

public class RegisterController {
    //注册逻辑
    public String RegisterUserController(String userRegisterUserName,String userRegisterUserPassword,String userRegisterSurePassword){
        return new CreateData().RegisterCreateData(userRegisterUserName,userRegisterUserPassword,userRegisterSurePassword);
    }
}
