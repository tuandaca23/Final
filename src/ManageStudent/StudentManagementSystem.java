package ManageStudent;

import Login.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementSystem extends JFrame {
    private JPanel mainPanel;
    private JButton btnExit;
    private JLabel lable;
    private JButton btnLogout;

    public StudentManagementSystem() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Đặt kích thước ban đầu của form quản lý sinh viên
        setSize(new Dimension(600, 250));

        btnExit.addActionListener(e -> System.exit(0));

        btnLogout.addActionListener(e -> showLoginForm());

        showStudentManagementForm();
    }

    public void showStudentManagementForm() {
        setContentPane(mainPanel);
        revalidate();
        repaint();
    }

    public void showLoginForm() {
        // Hiển thị form đăng nhập và ẩn form quản lý sinh viên
        Login loginForm = new Login();
        loginForm.setVisible(true);
        setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentManagementSystem();
            }
        });
    }
}
