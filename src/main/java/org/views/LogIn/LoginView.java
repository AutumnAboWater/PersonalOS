package org.views.LogIn;


import org.controller.LoginController;
import org.views.Menu.MenuView;
import org.views.Register.RegisterView;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginView {

    //每个小组件的流程
    // 设置类型->设置位置大小->添加
    JPanel root;
    //定义用户名和密码、标题面板😀
    JLabel userNameLabel,userPasswordLabel,LoginTitle;
    //定义用户名文本框,用户密码文本框😀
    JTextField userNameTextField,userPasswordTextField;
    //定义登录和注册俩按钮
    JButton LoginButton,RegisterButton;
    JLabel LogInMessage = new JLabel();
    LoginController loginController = new LoginController();
    public String userNameTextFieldTextData;
    public String  userLoginPassword;
    public void createLoginFrame() {
        //加载美化包系🚍
//        try {
//            BeautyEyeLNFHelper.launchBeautyEyeLNF();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        //实例化一个JFrame窗口对象👇
        JFrame frame = new JFrame("XX企业人事管理系统登录");

        //定义面板容器板子💛
        root = new JPanel();
        //定义标题标签并居中🏋️‍
        LoginTitle = new JLabel("XX企业人事管理系统");
        LoginTitle.setBounds(230,50,316,60);
        LoginTitle.setFont(new Font("Microsoft YaHei",Font.PLAIN,33));
        root.add(LoginTitle);

        //设置加载面板内容💙
        frame.setContentPane(root);

        //设置绝对布局🤎
        frame.setLayout(null);

        //用户名标签😀
        userNameLabel= new JLabel("用户名");//定义标签对象
        //位置以及大小设置😀
        userNameLabel.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        userNameLabel.setBounds(130,150,216,50);
        //添加进来😯
        root.add(userNameLabel);

        //输入用户名的文本框😏
        userNameTextField = new JTextField(12);
        //位置以及大小设置😀
        userNameTextField.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        userNameTextField.setBounds(250,158,300,40);
        //一样添加进来
        root.add(userNameTextField);

        //密码框的话就复制粘贴一样了,就是位置不一样y轴,纵坐标要加一点,靠下一点
        //用户密码标签😀
        userPasswordLabel= new JLabel("密码");//定义标签对象
        //位置以及大小设置😀
        userPasswordLabel.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        userPasswordLabel.setBounds(130,210,216,50);
        //添加进来😯
        root.add(userPasswordLabel);

        //输入密码的文本框🤦‍
        userPasswordTextField = new JPasswordField(12);
        //位置以及大小设置😀
        userPasswordTextField.setBounds(250,220,300,40);
        userPasswordTextField.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        //一样添加进来🙄
        root.add(userPasswordTextField);

        //登录按钮🆗
        LoginButton = new JButton("登录");
        //设置位置大小😔
        LoginButton.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        LoginButton.setBounds(230,290,138,46);
        //添加进来🙄
        root.add(LoginButton);

        //注册按钮 和登录一样 位置变下即可 🤦‍
        RegisterButton = new JButton("注册");
        //设置位置大小😔
        RegisterButton.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        RegisterButton.setBounds(450,290,138,46);
        //添加进来👇
        root.add(RegisterButton);
        //设置窗口风格😊
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(500,200,800,600);
        frame.setVisible(true);

        //设置一个登录的弹窗提醒
        JFrame LoginJDialog = new JFrame("提醒");
        Container contentPane = LoginJDialog.getContentPane();
        contentPane.setLayout(null);

        LoginJDialog.add(LogInMessage);
        LogInMessage.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        LogInMessage.setBounds(100,10,190,60);
        JButton sureButton = new JButton("确定");
        sureButton.setBounds(130,70,110,40);
        sureButton.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        contentPane.add(sureButton);
        contentPane.add(LogInMessage);
        LoginJDialog.setBounds(800,300,400,200);

        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userNameTextFieldTextData = userNameTextField.getText();
                 userLoginPassword = userPasswordTextField.getText();
                String LoginToken = loginController.Login(userNameTextFieldTextData, userLoginPassword);
                switch (LoginToken) {
                    case "登录成功":
                        LoginJDialog.setVisible(true);
                        LogInMessage.setText("登录成功");
                        break;
                    case "用户不存在":
                        LoginJDialog.setVisible(true);
                        LogInMessage.setText("用户不存在请注册");
                        break;
                    case "密码错误":
                        LoginJDialog.setVisible(true);
                        LogInMessage.setText("密码错误");
                        break;
                }
            }
        });
        sureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginJDialog.setVisible(false);
                frame.setVisible(false);
                new MenuView().createMenuFrame();
            }
        });
        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterView registerView = new RegisterView();
                JFrame registerView1 = registerView.createRegisterView();
                registerView1.setVisible(true);
            }
        });
    }
    public JLabel getMessage(){
        return LogInMessage;
    }
}
