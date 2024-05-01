package org.Baidu;

import org.views.LogIn.LoginView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChatAppBo {

    private final JTextField inputField;
    private final JTextArea chatArea;
    private final JScrollPane scrollPane;

    public ChatAppBo() {
        // 创建聊天窗口
        JFrame frame = new JFrame("Bo Chat");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(500,200, 600, 500);
        // 创建输入框和聊天区域
        inputField = new JTextField();
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true); // 设置自动换行
        chatArea.setWrapStyleWord(true); // 设置在单词边界断行

        // 创建滚动窗口
        scrollPane = new JScrollPane(chatArea);

        // 创建发送按钮
        JButton sendButton = new JButton("发送");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // 创建布局
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        // 将组件添加到窗口
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER); // 使用滚动窗口
        frame.add(panel, BorderLayout.SOUTH);

        // 设置窗口可见
        frame.setVisible(true);
    }

    private void sendMessage() {
        // 获取用户输入
        String userMessage = inputField.getText();
        // 显示用户消息到聊天区域
        String userNameTextFieldTextData = new LoginView().userNameTextFieldTextData;
        appendToChatArea(userNameTextFieldTextData + userMessage);

        try {
            // 获取百度AI的回复
            String aiReply = getBaiduAIReply(userMessage);
            // 显示AI回复到聊天区域
            appendToChatArea("AI: " + aiReply);
        } catch (Exception e) {
            appendToChatArea("AI发生了莫名其妙的错误.");
        }

        // 清空输入框
        inputField.setText("");

        // 滚动到最后一行
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setValue(verticalScrollBar.getMaximum());
    }

    private void appendToChatArea(String message) {
        chatArea.append(message + "\n");
    }

    private String getBaiduAIReply(String userMessage) throws IOException, InterruptedException {
        // TODO: 实现获取百度AI回复的逻辑，调用 BaiduChatMain 的 BoChat 方法
        return new BaiduChatMain().BoChat(userMessage);
    }

}
