package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Project.AdminCon;
import Project.UniversityManagement;

class LoginFrame extends JFrame implements ActionListener {
    
    Container container=getContentPane();
    JButton StudentButton=new JButton("Student");
    JButton StaffButton=new JButton("Staff");
    JButton AdminButton=new JButton("Admin");
    
    LoginFrame(){ 
          setLayoutManager();
          setLocationAndSize();
          addComponentsToContainer();
          addActionEvent();
          }
    
    public void setLayoutManager(){
        container.setLayout(null);
        setTitle("Login Form");
        setVisible(true);
        setBounds(10,10,370,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    public void setLocationAndSize(){
        StudentButton.setBounds(135,100,100,30);
        StaffButton.setBounds(135,200,100,30);
        AdminButton.setBounds(135,300,100,30);
    }
    
    public void addComponentsToContainer(){
        container.add(StudentButton);
        container.add(StaffButton);
        container.add(AdminButton);
    }
    public void addActionEvent()
   {
       StudentButton.addActionListener(this);
       StaffButton.addActionListener(this);
       AdminButton.addActionListener(this);
   }
    @Override
    public void actionPerformed(ActionEvent e) {       
        if(e.getSource()==AdminButton){
            dispose();
            AdminLogin admin = new AdminLogin();
            }
        if(e.getSource()==StaffButton){
            dispose();
            StaffLogin staff = new StaffLogin();
            }
        if(e.getSource()==StudentButton){
            dispose();
            StudentLogin student = new StudentLogin();
            }
    }
}

class StudentLogin extends JFrame implements ActionListener{
    Container container=getContentPane();
    JLabel SLabel = new JLabel("StudentLogin");
    JLabel userLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("RESET");
    JCheckBox showPassword=new JCheckBox("Show Password");
    JButton Back=new JButton("Back");
    
    
    StudentLogin(){ 
          setLayoutManager();
          setLocationAndSize();
          addComponentsToContainer();
          addActionEvent();      
          }

    public void setLayoutManager(){
        container.setLayout(null);
        setTitle("Student Login");
        setVisible(true);
        setBounds(10,10,370,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    public void setLocationAndSize(){
        SLabel.setBounds(120,100,200,30);
        SLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        userLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        userTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        resetButton.setBounds(200,300,100,30);
        Back.setBounds(125,400,100,30);
    }
    
    public void addComponentsToContainer(){
        container.add(SLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(Back);
    }
    public void addActionEvent()
   {
       loginButton.addActionListener(this);
       resetButton.addActionListener(this);
       showPassword.addActionListener(this);
       Back.addActionListener(this);
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            studentManagement obj=new studentManagement();
            int x = obj.StudentValidation(userText,pwdText);
            if (x==1) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                StudentMain Sframe = new StudentMain();
                dispose();
            } else if(x==2){
                JOptionPane.showMessageDialog(this, "You are not student");
            }else{
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
 
        }

        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
        if(e.getSource()==Back){
            LoginFrame frame = new LoginFrame();
            dispose();
        }
    }
}
class StaffLogin extends JFrame implements ActionListener{
    Container container=getContentPane();
    JLabel SLabel = new JLabel("StaffLogin");
    JLabel userLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("RESET");
    JCheckBox showPassword=new JCheckBox("Show Password");
    JButton Back=new JButton("Back");
    
    
    StaffLogin(){ 
          setLayoutManager();
          setLocationAndSize();
          addComponentsToContainer();
          addActionEvent();      
          }

    public void setLayoutManager(){
        container.setLayout(null);
        setTitle("Student Login");
        setVisible(true);
        setBounds(10,10,370,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    public void setLocationAndSize(){
        SLabel.setBounds(120,100,200,30);
        SLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        userLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        userTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        resetButton.setBounds(200,300,100,30);
        Back.setBounds(125,400,100,30);
    }
    
    public void addComponentsToContainer(){
        container.add(SLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(Back);
    }
    public void addActionEvent()
   {
       loginButton.addActionListener(this);
       resetButton.addActionListener(this);
       showPassword.addActionListener(this);
       Back.addActionListener(this);
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            staffManagement obj=new staffManagement();
            int x = obj.StaffValidation(userText,pwdText);
            if (x==1) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                StaffMain Sframe = new StaffMain();
                dispose();
            } else if(x==2){
                JOptionPane.showMessageDialog(this, "You are not staff");
            }else{
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
 
        }

        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
        if(e.getSource()==Back){
            LoginFrame frame = new LoginFrame();
            dispose();
        }
    }
}
class AdminLogin extends JFrame implements ActionListener{
    Container container=getContentPane();
    JLabel SLabel = new JLabel("AdminLogin");
    JLabel userLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("RESET");
    JCheckBox showPassword=new JCheckBox("Show Password");
    JButton Back=new JButton("Back");
    
    
    AdminLogin(){ 
          setLayoutManager();
          setLocationAndSize();
          addComponentsToContainer();
          addActionEvent();      
          }

    public void setLayoutManager(){
        container.setLayout(null);
        setTitle("Admin Login");
        setVisible(true);
        setBounds(10,10,370,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    public void setLocationAndSize(){
        SLabel.setBounds(120,100,200,30);
        SLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        userLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        userTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        resetButton.setBounds(200,300,100,30);
        Back.setBounds(125,400,100,30);
    }
    
    public void addComponentsToContainer(){
        container.add(SLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(Back);
    }
    public void addActionEvent()
   {
       loginButton.addActionListener(this);
       resetButton.addActionListener(this);
       showPassword.addActionListener(this);
       Back.addActionListener(this);
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            admin obj = new admin();
            String a = obj.username;
            String b = obj.password;
            if (userText.equalsIgnoreCase(a) && pwdText.equalsIgnoreCase(b)) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                WELCOME Sframe = new WELCOME();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
 
        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
        
        
        
        if(e.getSource()==Back){
            LoginFrame frame = new LoginFrame();
            dispose();
        }
    }
}


class Login {
    public static void main(String args[]) {

        new LoginFrame();

    }
}