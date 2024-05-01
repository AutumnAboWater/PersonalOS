package org.views.Menu;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import org.Baidu.ChatAppBo;
import org.controller.SelectController;

public class MenuView{
    private JButton createButton;
    private JButton selectButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton exitButton;
    private JButton chatButton;
    private JButton sureButton;
    private JTable table1;
    private JPanel MenuView;

    public MenuView() {

        // 创建默认表格模型，并设置字段名称和数据
        DefaultTableModel tableModel = new DefaultTableModel() {
            //禁用修改
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // 创建JTable并设置模型
        table1.setModel(tableModel);
        table1.setFont(new Font("SimSun", Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(table1);
        table1.setRowHeight(40);
        // 创建侧边按钮面板
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(6, 6));
        sidePanel.add(createButton);
        sidePanel.add(selectButton);
        sidePanel.add(updateButton);
        sidePanel.add(deleteButton);
        sidePanel.add(chatButton);
        sidePanel.add(exitButton);

        // 创建内容面板
        MenuView.setLayout(new BorderLayout());
        MenuView.add(scrollPane, BorderLayout.CENTER);
        MenuView.add(sidePanel, BorderLayout.WEST);

        //设置一个查询的弹窗提醒
        JFrame SelectJDialog = new JFrame("提醒");
        Container contentPane = SelectJDialog.getContentPane();
        contentPane.setLayout(null);
        JLabel DialogMessage = new JLabel();
        SelectJDialog.add(DialogMessage);
        DialogMessage.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        DialogMessage.setBounds(100,10,190,60);
        sureButton = new JButton("确定");
        sureButton.setBounds(130,70,110,40);
        sureButton.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
        contentPane.add(sureButton);
        contentPane.add(DialogMessage);
        SelectJDialog.setBounds(800,300,400,200);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                String menuSelectController = new SelectController().menuSelectController(tableModel);
                if (menuSelectController.equals("信息查询成功")){
                    SelectJDialog.setVisible(true);
                    DialogMessage.setText("查询成功!");
                }else {
                    SelectJDialog.setVisible(true);
                    DialogMessage.setText("查询失败!");
                }
            }
        });
        sureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectJDialog.setVisible(false);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new deleteStaffDataView();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new updateStaffDataView();
            }
        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addStaffDataView();
            }
        });
        chatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChatAppBo();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public  void createMenuFrame() {

            JFrame frame = new JFrame("XX企业人事管理系统");
            frame.setVisible(true);
            MenuView menuView = new MenuView(); // 创建 MenuView 实例
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocation(500,200);
            JLabel jLabel = new JLabel();
            jLabel.setText("XX企业人事管理系统");
            frame.add(jLabel);
            frame.setContentPane(menuView.MenuView);
            frame.pack();
//
//            LoginView loginView = new LoginView();
//            JLabel message = loginView.getMessage();
//        System.out.println(message.getText());
//            if (message.getText().equals("登录成功")){
//                frame.setVisible(true);
//            }else {
//                //设置一个不是登录过来直接打开主页的弹窗提醒
//                JFrame ErrorJDialog = new JFrame("提醒");
//                Container ErrorContentPane = ErrorJDialog.getContentPane();
//                ErrorContentPane.setLayout(null);
//                JLabel ErrorDialogMessage = new JLabel();
//                ErrorJDialog.add(ErrorDialogMessage);
//                ErrorDialogMessage.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
//                ErrorDialogMessage.setBounds(100,10,190,60);
//                JButton ErrorSureButton = new JButton("确定");
//                ErrorSureButton.setBounds(130,70,110,40);
//                ErrorSureButton.setFont(new Font("Microsoft YaHei",Font.PLAIN,20));
//                ErrorContentPane.add(ErrorSureButton);
//                ErrorContentPane.add(ErrorDialogMessage);
//                ErrorJDialog.setBounds(1150,650,400,200);
//                ErrorSureButton.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        ErrorJDialog.setVisible(false);
//                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                        new LoginView().createLoginFrame();
//                    }
//                });
//                ErrorJDialog.setVisible(true);
//                ErrorDialogMessage.setText("请登录!");
//            }
    }
}
