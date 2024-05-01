package org.views.Menu;


import org.controller.CRUD.SelectData;
import org.controller.UpdateController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class updateStaffDataView {
    public final JFrame frame;
    public final JTextField idTextField;
    public final JTextField nameTextField;
    public final JTextField ageTextField;
    public final JTextField genderTextField;
    public final JTextField numberTextField;
    public final JTextField deptTextField;
    public final JButton updateButton;
    public final JButton selectButton;

    public updateStaffDataView() {
        //全局字体大小设置

        frame = new JFrame("修改员工信息");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(500,200,800,600);

        frame.setLayout(new GridLayout(7, 2, 10, 10)); // 设置行列间距


        JLabel staffId = new JLabel("员工编号:");
        idTextField = new JTextField();

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
        JFrame UpdateJDialog = new JFrame("请输入员工编号或员工姓名进行查询修改");
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

        // 添加员工名字输入框
        JLabel DialogStaffName= new JLabel("员工名字:");
        JTextField employeeNameTextField = new JTextField();
        DialogStaffName.setBounds(100,70,100,30);
        setAllFont(DialogStaffName,employeeNameTextField);
        employeeNameTextField.setBounds(200, 70, 190, 30);
        contentPane.add(employeeNameTextField);
        contentPane.add(DialogStaffName);

        JLabel DialogMessage = new JLabel();
        UpdateJDialog.add(DialogMessage);
        DialogMessage.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
        DialogMessage.setBounds(200, 80, 190, 60);

        JButton sureButton = new JButton("确定");
        sureButton.setBounds(230, 150, 110, 40);
        sureButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));

        contentPane.add(sureButton);
        contentPane.add(DialogMessage);

        UpdateJDialog.setBounds(800,300, 600, 250);

        //设置一个修改的弹窗提醒
        JFrame newUpdateJDialog = new JFrame("提醒");
        Container newContentPane = newUpdateJDialog.getContentPane();
        newContentPane.setLayout(null);
        JLabel newDialogMessage = new JLabel();
        newUpdateJDialog.add(newDialogMessage);
        newDialogMessage.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        newDialogMessage.setBounds(100,10,190,60);
        JButton newSureButton = new JButton("确定");
        newSureButton.setBounds(130,70,110,40);
        newSureButton.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        newContentPane.add(newSureButton);
        newContentPane.add(newDialogMessage);
        newUpdateJDialog.setBounds(800,300,400,200);




        updateButton = new JButton("更新数据");
        updateButton.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        selectButton = new JButton("查询数据");
        selectButton.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newName = nameTextField.getText();
                String newNumber = numberTextField.getText();
                String newGender = genderTextField.getText();
                String newAge = ageTextField.getText();
                String newDept = deptTextField.getText();
                String updatedStaffDataMessage = new UpdateController().updateStaffData(
                        newName, newAge, newGender, newNumber, newDept, idTextField.getText()
                );
                System.out.println(updatedStaffDataMessage);
                if (updatedStaffDataMessage.equals("修改成功")){
                    newUpdateJDialog.setVisible(true);
                    newDialogMessage.setText("修改成功!");
                }
            }
        });
        selectButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateJDialog.setVisible(true);
                DialogMessage.setText("请输入员工编号或员工姓名进行查询修改");
            }
        });
        sureButton.addActionListener(new ActionListener() {
            String StaffId;
            String StaffName;
            String StaffAge;
            String StaffGender;
            String StaffNumber;
            String Staffedept;



            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, String> stringHashMap;
                String newNameTextFieldText = employeeNameTextField.getText();
                String employeeIdTextFieldText = employeeIdTextField.getText();
//                System.out.println(newNameTextFieldText);
                if (employeeIdTextFieldText.isEmpty()){
                     stringHashMap = new SelectData().selectStaffData(newNameTextFieldText);
                }else {
                     stringHashMap = new SelectData().selectStaffData(employeeIdTextFieldText);

                }
//                遍历
//             疑问点 为什么调用toString方法输出为空，遍历结果不为空
//                System.out.println("--------查询信息如下:----------");
//                Set<Map.Entry<String, String>> entries = stringHashMap.entrySet();
//                for (Map.Entry<String,String> entry:entries){
//                    System.out.println(entry.getKey()+" "+entry.getValue());
//                }
                //调用toString方法
//                System.out.println(this);

                StaffId = stringHashMap.get("StaffId");
                StaffName = stringHashMap.get("StaffName");
                StaffAge = stringHashMap.get("StaffAge");
                StaffGender = stringHashMap.get("StaffGender");
                StaffNumber = stringHashMap.get("StaffNumber");
                Staffedept = stringHashMap.get("Staffedept");
                idTextField.setText(StaffId);
                nameTextField.setText(StaffName);
                numberTextField.setText(StaffNumber);
                genderTextField.setText(StaffGender);
                ageTextField.setText(StaffAge);
                deptTextField.setText(Staffedept);
                UpdateJDialog.setVisible(false);
            }
            @Override
            public String toString() {
                return "$classname{" +
                        "StaffId='" + StaffId + '\'' +
                        ", StaffName='" + StaffName + '\'' +
                        ", StaffAge='" + StaffAge + '\'' +
                        ", StaffGender='" + StaffGender + '\'' +
                        ", StaffNumber='" + StaffNumber + '\'' +
                        ", Staffedept='" + Staffedept + '\'' +
                        '}';
            }
        });

        newSureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newUpdateJDialog.setVisible(false);
            }
        });
        frame.add(selectButton);
        frame.add(updateButton);
        frame.setVisible(true);
    }

    public void setAllFont(JLabel jLabel,JTextField jTextField){
        jLabel.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        jTextField.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(updateStaffDateView::new);
//    }
}
