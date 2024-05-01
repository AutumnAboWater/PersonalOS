package org.views;



import javax.swing.*;
import java.awt.*;

public class MenuFrame {
    //大致流程 窗口->容器->面板->小框(输入框/按钮等)  页面排版排好
    //不能添加测试方法 测试方法debug显示不出来好像🤔
    //定义一个小面板板😀
    JPanel root;
    //定义用户名和密码面板😀
    JLabel userNameLabel,userPasswordLabel;
    //定义用户名文本框,用户密码文本框😀
    JTextField userNameTextField,userPasswordTextField;
    //定义登录和注册俩按钮
    JButton LoginButton,RegisterButton;
    public void createMenuFrame(){
        //加载美化包
//        new MakeFrameBeauty().makeYouFrameBeBeautify();

        //实例化一个JFrame窗口对象👇
        JFrame frame = new JFrame("XX企业人事管理系统");

        //获取容器👇
        Container container = frame.getContentPane();

        //实例化一个JPanel面板对象👇
        root = new JPanel();

        //创建JLabel标签👇
        JLabel label = new JLabel("XX企业人事管理系统");

        //标签上的文字居中👇
        label.setHorizontalAlignment(SwingConstants.CENTER);

        //设置JLabel中的字体样式和大小👇
        label.setFont(new Font("Microsoft YaHei",Font.PLAIN,60));

        //将标签添加到JPanel中👇
        root.add(label);

        //将JPanel添加到容器中~👇
        container.add(root);

        //窗体可视👇
        frame.setVisible(true);

        //设置窗体显示位置和大小👇
        frame.setBounds(900,500,800,600);

        //设置窗口关闭方式👇
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
