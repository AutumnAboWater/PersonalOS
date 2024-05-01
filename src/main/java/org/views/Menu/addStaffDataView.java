package org.views.Menu;

import org.controller.CreateController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addStaffDataView {
    public final JFrame frame;
    public final JTextField idTextField;
    public final JTextField nameTextField;
    public final JTextField ageTextField;
    public final JTextField genderTextField;
    public final JTextField numberTextField;
    public final JTextField deptTextField;
    public final JButton resetButton;
    public final JButton addSureButton;
    public addStaffDataView(){
        //全局字体大小设置

        frame = new JFrame("录入员工信息");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(500,200,800,600);

        frame.setLayout(new GridLayout(7, 2, 10, 10)); // 设置行列间距


        JLabel staffId = new JLabel("员工编号:");
        frame.add(staffId);
        idTextField = new JTextField();
        frame.add(idTextField);

        JLabel staffName = new JLabel("员工姓名:");
        frame.add(staffName);
        nameTextField = new JTextField();
        frame.add(nameTextField);

        JLabel staffAge = new JLabel("员工年龄:");
        frame.add(staffAge);
        ageTextField = new JTextField();
        frame.add(ageTextField);

        JLabel staffGender = new JLabel("员工性别:");
        frame.add(staffGender);
        genderTextField = new JTextField();
        frame.add(genderTextField);

        JLabel staffNumber = new JLabel("员工手机号:");
        frame.add(staffNumber);
        numberTextField = new JTextField();
        frame.add(numberTextField);

        JLabel staffDept = new JLabel("员工所属部门:");
        frame.add(staffDept);
        deptTextField = new JTextField();
        frame.add(deptTextField);

        setAllFont(staffId,idTextField);
        setAllFont(staffName,nameTextField);
        setAllFont(staffNumber,numberTextField);
        setAllFont(staffGender,genderTextField);
        setAllFont(staffAge,ageTextField);
        setAllFont(staffDept,deptTextField);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //设置一个修改的弹窗
        JFrame UpdateJDialog = new JFrame("请输入员工编号进行查询修改");
        Container contentPane = UpdateJDialog.getContentPane();
        contentPane.setLayout(null);
        // 添加员工编号输入框
        JLabel DialogStaffId = new JLabel("员工编号:");
        JTextField employeeIdTextField = new JTextField();
        DialogStaffId.setBounds(100,10,100,30);
        setAllFont(DialogStaffId,employeeIdTextField);
        employeeIdTextField.setBounds(200, 10, 190, 30);
        contentPane.add(employeeIdTextField);
        contentPane.add(DialogStaffId);

        JLabel DialogMessage = new JLabel();
        UpdateJDialog.add(DialogMessage);
        DialogMessage.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
        DialogMessage.setBounds(200, 50, 190, 60);

        JButton sureButton = new JButton("确定");
        sureButton.setBounds(230, 120, 110, 40);
        sureButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));

        contentPane.add(sureButton);
        contentPane.add(DialogMessage);

        UpdateJDialog.setBounds(800,300, 600, 250);

        //设置一个添加的弹窗提醒
        JFrame addJDialog = new JFrame("提醒");
        Container addContentPane = addJDialog.getContentPane();
        addContentPane.setLayout(null);
        JLabel addDialogMessage = new JLabel();
        addJDialog.add(addDialogMessage);
        addDialogMessage.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        addDialogMessage.setBounds(100,10,190,60);
        JButton addButton = new JButton("确定");
        addButton.setBounds(130,70,110,40);
        addButton.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        addContentPane.add(addButton);
        addContentPane.add(addDialogMessage);
        addJDialog.setBounds(800,300,400,200);




        resetButton = new JButton("重置");
        resetButton.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        addSureButton = new JButton("确定");
        addSureButton.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));


        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        idTextField.setText("");
                        nameTextField.setText("");
                        numberTextField.setText("");
                        genderTextField.setText("");
                        ageTextField.setText("");
                        deptTextField.setText("");
                        addJDialog.setVisible(true);
                        addDialogMessage.setText("重置成功!");
            }
        });
        addSureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newId = idTextField.getText();
                String newName = nameTextField.getText();
                String newNumber = numberTextField.getText();
                String newGender = genderTextField.getText();
                String newAge = ageTextField.getText();
                String newDept = deptTextField.getText();
                String staffDataController = new CreateController().createStaffDataController(newId, newName, newAge, newGender, newNumber, newDept);
                if (newId.isEmpty() || newName.isEmpty() || newNumber.isEmpty() || newGender.isEmpty() || newAge.isEmpty() || newDept.isEmpty()) {
                    addJDialog.setVisible(true);
                    addDialogMessage.setText("字段不能为空");
                    staffDataController = "添加失败";
                }
                if (staffDataController.equals("添加成功")){
                    addJDialog.setVisible(true);
                    addDialogMessage.setText("添加成功!");
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addJDialog.setVisible(false);
            }
        });

        frame.add(addSureButton);
        frame.add(resetButton);
        frame.setVisible(true);
    }

    public void setAllFont(JLabel jLabel,JTextField jTextField){
        jLabel.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        jTextField.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
    }
}