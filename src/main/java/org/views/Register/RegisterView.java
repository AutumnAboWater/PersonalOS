package org.views.Register;



import org.controller.RegisterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView {
    JFrame frame = new JFrame("XX企业人事管理系统");
    private JPanel RegisterMain;
    private JLabel bigTitle;
    private JLabel passwordTitle;
    private JLabel userTitle;
    private JLabel surePasswordTitle;
    private JTextField userNameField;
    private JTextField passwordField1;
    private JTextField passwordField2;
    private JButton RegisterSureButton;
    private JButton RegisterResetButton;
    private JPanel RegisterViewFrame;
    public RegisterView() {
        //设置一个注册的弹窗提醒
        JFrame RegisterJDialog = new JFrame("提醒");
        Container contentPane = RegisterJDialog.getContentPane();
        contentPane.setLayout(null);
        JLabel DialogMessage = new JLabel();
        RegisterJDialog.add(DialogMessage);
        DialogMessage.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        DialogMessage.setBounds(100,10,190,60);
        JButton sureButton = new JButton("确定");
        sureButton.setBounds(130,70,110,40);
        sureButton.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        contentPane.add(sureButton);
        contentPane.add(DialogMessage);
        RegisterJDialog.setBounds(800,300,400,200);
        RegisterSureButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String userNameFieldText = userNameField.getText();
                String userRegisterPassword = passwordField1.getText();
                String userRegisterSurePassword  = passwordField2.getText();
                String RegisterMessage = new RegisterController().RegisterUserController(userNameFieldText, userRegisterPassword, userRegisterSurePassword);
                if (RegisterMessage.equals("注册成功")){
                    RegisterJDialog.setVisible(true);
                    DialogMessage.setText("注册成功");
                }else {
                    RegisterJDialog.setVisible(true);
                    DialogMessage.setText("两次密码不一样，请重新尝试");
                }
            }
        });
        RegisterResetButton.addActionListener(new ActionListener() {
            /**
             * Go to
             *
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField1.setText("");
                passwordField2.setText("");
                userNameField.setText("");
            }
        });
        sureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterJDialog.setVisible(false);
            }
        });
    }
    public JFrame createRegisterView(){
        frame.setContentPane(new RegisterView().RegisterViewFrame);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocation(500,200);
        return frame;
    }
}
