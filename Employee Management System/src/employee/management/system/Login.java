package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername, tfpassword;
    
    Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel Title = new JLabel("Employee Management System");
        Title.setBounds(150,10, 300, 30);
        add(Title);
        
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 50, 100, 30);
        add(lblusername); 

        
        tfusername = new JTextField();
        tfusername.setBounds(150, 50, 300, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 100, 100, 30);
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 100, 300, 30);
        add(tfpassword);
        
        JButton login = new JButton("LOGIN");
        login.setBounds(150, 170, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        setSize(500, 300);
        setLocation(500, 280);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            Conn c = new Conn();
            
           String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
          ResultSet rs = c.s.executeQuery(query);
           if (rs.next()) {
                setVisible(false); 
                new Home();
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            } 
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}