package org.util;

public class verify {
    public verify(boolean verifyBoolean,String verifyName) {
        if (!verifyBoolean){
            System.out.println(verifyName+":Success-模块加载成功");
        }else {
            System.out.println(verifyName+":Error-模块加载失败");
        }
    }
}
