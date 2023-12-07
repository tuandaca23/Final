package Login;

import ManageStudent.StudentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame {
    private JPanel mainPanel;
    private JTextField userName;
    private JPasswordField pass;
    private JButton btnLogin;
    private JButton btnCancel;

    Connection conn;
    Statement statement;
    ResultSet rs;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });
    }

    public Login() {
        super("Login");
        conn = databaseConnection.connection();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(600, 250));
        pack();
        setLocationRelativeTo(null); // Đặt vị trí hiển thị ở giữa màn hình
        setVisible(true);

        btnCancel.addActionListener(e -> System.exit(0));

        btnLogin.addActionListener(e -> performLogin());

        pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });

        // Thêm KeyListener cho trường userName để kích hoạt nút đăng nhập khi nhấn Enter
        userName.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performLogin();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    private void performLogin() {
        try {
            statement = conn.createStatement();
            String UserName = userName.getText();
            String Password = new String(pass.getPassword());
            String sql = "Select * from user where " +
                    "userName = '" + UserName + "' and " +
                    "password = '" + Password + "'";
            rs = statement.executeQuery(sql);

            if (rs.next()) {
                // Đăng nhập thành công, ẩn form đăng nhập và hiển thị form quản lý sinh viên
                setVisible(false);
                new StudentManagementSystem().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(Login.this, "UserName or Password is Incorrect!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
