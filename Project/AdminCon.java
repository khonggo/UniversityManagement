package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Project.UniversityManagement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Project.Login;

class AddInfoTable extends JFrame implements ActionListener{
    Container container=getContentPane();
    JMenu menu1,menu2,menu3,menu4,menu5,submenu; 
    JMenuItem i1, i5; 
    JMenuItem i6; 
    JMenuItem i11, i15,i25; 
    JMenuItem i16,i20; 
    JLabel userLabel=new JLabel("USERNAME :");
    JLabel passwordLabel=new JLabel("PASSWORD :");
    JLabel fullnameLabel=new JLabel("FullNAME :");
    JLabel PhonenumLabel=new JLabel("Phonenumber :");
    JLabel addressLabel=new JLabel("Address :");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JTextField fullnameField=new JTextField();
    JTextField PhonenumField=new JTextField();
    JTextField addressField=new JTextField();
    JButton AddButton=new JButton("Add");
    JRadioButton r1=new JRadioButton("Student");    
    JRadioButton r2=new JRadioButton("Staff");  
    ButtonGroup group = new ButtonGroup();
    
    AddInfoTable(){
        setLayoutManager();
        setmenu();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setButton();
    }
    public void setButton(){
        group.add(r1);
        group.add(r2);
    }
    public void setmenu(){  
          JMenuBar mb=new JMenuBar();  
          menu1=new JMenu("Add");  
          menu2=new JMenu("Edit");
          menu3=new JMenu("View");
          menu4=new JMenu("Delete"); 
          menu5=new JMenu("Setting");
          submenu=new JMenu("Finance");
          i1=new JMenuItem("Information");  
          i5=new JMenuItem("Finance");  
          i6=new JMenuItem("Information"); 
          i11=new JMenuItem("Information"); 
          i15=new JMenuItem("Overall Finance"); 
          i25=new JMenuItem("Personal Finance");
          i16=new JMenuItem("Information"); 
          i20=new JMenuItem("Logout");
          menu1.add(i1);menu1.add(i5);    
          menu2.add(i6);
          menu3.add(i11); menu3.add(submenu);
          submenu.add(i15);submenu.add(i25);
          menu4.add(i16); 
          menu5.add(i20);
          mb.add(menu1); 
          mb.add(menu2); 
          mb.add(menu3); 
          mb.add(menu4); 
          mb.add(menu5);
          setJMenuBar(mb);   
}
    public void setLocationAndSize(){
        userLabel.setBounds(50,50,100,30);
        passwordLabel.setBounds(50,100,100,30);
        fullnameLabel.setBounds(50,150,100,30);
        PhonenumLabel.setBounds(50,200,100,30);
        addressLabel.setBounds(50,250,100,30);
        userTextField.setBounds(150,50,150,30);
        passwordField.setBounds(150,100,150,30);
        fullnameField.setBounds(150,150,150,30);
        PhonenumField.setBounds(150,200,150,30);
        addressField.setBounds(150,250,150,30);
        AddButton.setBounds(120,350,100,30);
        r1.setBounds(50,300,100,30);
        r2.setBounds(150,300,100,30);
    }
    
     public void addComponentsToContainer(){
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(fullnameLabel);
        container.add(PhonenumLabel);
        container.add(addressLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(fullnameField);
        container.add(PhonenumField);
        container.add(addressField);
        container.add(AddButton);
        container.add(r1);
        container.add(r2);
     }
     
    public void setLayoutManager(){
        container.setLayout(null);
        setBounds(10,10,370,600);
        setTitle("AdminPage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
     public void addActionEvent()
   {
      //adding Action listener to components
       AddButton.addActionListener(this);
       i11.addActionListener(this);
       i6.addActionListener(this);
       i16.addActionListener(this);
       i20.addActionListener(this);
       i5.addActionListener(this);
       i15.addActionListener(this);
       i25.addActionListener(this);
   }
     
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == AddButton) {
            String userText;
            String pwdText;
            String nameText;
            String phText;
            String adrsText;
            String PosText="";
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            nameText = fullnameField.getText();
            phText = PhonenumField.getText();
            adrsText = addressField.getText();
            if(r1.isSelected()){    
            PosText = "Student"   ;
            }    
            if(r2.isSelected()){    
            PosText = "Staff"   ;  
            }    
            if(userText.equals("")||pwdText.equals("")||nameText.equals("")||phText.equals("")||adrsText.equals("")||PosText.equals("")){
                JOptionPane.showMessageDialog(this, "Please fill all information.");
            }else{
            admin obj = new admin();
            obj.addUser(userText, pwdText, nameText, phText, adrsText,PosText);
            JOptionPane.showMessageDialog(this, "Add Successful");
            userTextField.setText("");
            passwordField.setText("");
            fullnameField.setText("");
            PhonenumField.setText("");
            addressField.setText("");
        }}
        if(e.getSource()==i20){
            LoginFrame lgn = new LoginFrame();
            dispose();
        }
        if(e.getSource()==i11){
            ViewInfoTable obj11 = new ViewInfoTable();
            dispose();
        }
        if(e.getSource()==i5){
            AddFinance obj5 = new AddFinance();
            dispose();
        }
        if(e.getSource()==i15){
            ViewFinance obj15 = new ViewFinance();
            dispose();
        }
        if(e.getSource()==i25){
            ViewMoreFinance obj25 = new ViewMoreFinance();
            dispose();
        }
        if(e.getSource()==i6){
            EditInfoTable obj6 = new EditInfoTable();
            dispose();
        }
        if(e.getSource()==i16){
            RemoveInfoTable obj16 = new RemoveInfoTable();
            dispose();
        }
    }
}

class ViewInfoTable extends JFrame implements ActionListener{
    Container container=getContentPane();
    JMenu menu1,menu2,menu3,menu4,menu5,submenu;  
    JMenuItem i1, i5; 
    JMenuItem i6; 
    JMenuItem i11, i15,i25; 
    JMenuItem i16,i20; 
    java.util.List<String> columns = new ArrayList<String>();
    java.util.List<String[]> values = new ArrayList<String[]>();
    
    ViewInfoTable(){
        setmenu();
        setBounds(10,10,1060,600);
        setTitle("AdminPage");
        setTable();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addActionEvent();
    }
        public void setmenu(){  
          JMenuBar mb=new JMenuBar();  
          menu1=new JMenu("Add");  
          menu2=new JMenu("Edit");
          menu3=new JMenu("View");
          menu4=new JMenu("Delete"); 
          menu5=new JMenu("Setting");
          submenu=new JMenu("Finance");
          i1=new JMenuItem("Information");  
          i5=new JMenuItem("Finance");  
          i6=new JMenuItem("Information"); 
          i11=new JMenuItem("Information"); 
          i15=new JMenuItem("Overall Finance"); 
          i25=new JMenuItem("Personal Finance");
          i16=new JMenuItem("Information"); 
          i20=new JMenuItem("Logout");
          menu1.add(i1);menu1.add(i5);    
          menu2.add(i6);
          menu3.add(i11); menu3.add(submenu);
          submenu.add(i15);submenu.add(i25);
          menu4.add(i16); 
          menu5.add(i20);
          mb.add(menu1); 
          mb.add(menu2); 
          mb.add(menu3); 
          mb.add(menu4); 
          mb.add(menu5);
          setJMenuBar(mb);    
}
    public void setTable(){

           UniversityManagement obj= new UniversityManagement();

            columns.add("UserID");
            columns.add("Password");
            columns.add("FullName");
            columns.add("Phonenumber");
            columns.add("Address");
            columns.add("Position");
            for(int i=0;i<obj.unique_id;i++){
                values.add(new String[] {obj.userID[i],obj.password[i],obj.fullName[i],obj.phonenumber[i],obj.address[i],obj.position[i]});
            }
            TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
            JTable table = new JTable(tableModel);
            add(new JScrollPane(table), BorderLayout.CENTER);
            add(table.getTableHeader(), BorderLayout.NORTH);
    }
    

         public void addActionEvent()
   {
      //adding Action listener to components
       i1.addActionListener(this);
       i6.addActionListener(this);
       i16.addActionListener(this);
       i20.addActionListener(this);
       i5.addActionListener(this);
       i15.addActionListener(this);
   }
     
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==i1){
            AddInfoTable obj1 = new AddInfoTable();
            dispose();
        }
        if(e.getSource()==i5){
            AddFinance obj5 = new AddFinance();
            dispose();
        }
        if(e.getSource()==i6){
            EditInfoTable obj6 = new EditInfoTable();
            dispose();
        }
        if(e.getSource()==i15){
            ViewFinance obj15 = new ViewFinance();
            dispose();
        }
        if(e.getSource()==i25){
            ViewMoreFinance obj25 = new ViewMoreFinance();
            dispose();
        }
        if(e.getSource()==i16){
            RemoveInfoTable obj16 = new RemoveInfoTable();
            dispose();
        }
        if(e.getSource()==i20){
            LoginFrame lgn = new LoginFrame();
            dispose();
        }
    }  
}

class EditInfoTable extends JFrame implements ActionListener{
    Container container=getContentPane();
    JMenu menu1,menu2,menu3,menu4,menu5,submenu;  
    JMenuItem i1, i5; 
    JMenuItem i6; 
    JMenuItem i11, i15,i25; 
    JMenuItem i16,i20; 
    JLabel Title=new JLabel("EDIT");
    JLabel userLabel=new JLabel("USER :");
    JLabel passwordLabel=new JLabel("SELECTION :");
    JLabel Value = new JLabel("NEW VALUE :");
    JTextField valueField=new JTextField();
    UniversityManagement obj= new UniversityManagement();
    JComboBox c1 = new JComboBox(obj.userID);
    String s1[] = {"UserID","Password","Name","Phonenumber","address"};
    JComboBox c2 = new JComboBox(s1);
    JButton EditButton=new JButton("Submit");
            
    EditInfoTable(){
        setmenu();
        setLayoutManager();
        addActionEvent();
        setLocationAndSize();
        addComponentsToContainer();
    }
    
        public void setmenu(){  
          JMenuBar mb=new JMenuBar();  
          menu1=new JMenu("Add");  
          menu2=new JMenu("Edit");
          menu3=new JMenu("View");
          menu4=new JMenu("Delete"); 
          menu5=new JMenu("Setting");
          submenu=new JMenu("Finance");
          i1=new JMenuItem("Information");  
          i5=new JMenuItem("Finance");  
          i6=new JMenuItem("Information"); 
          i11=new JMenuItem("Information"); 
          i15=new JMenuItem("Overall Finance"); 
          i25=new JMenuItem("Personal Finance");
          i16=new JMenuItem("Information"); 
          i20=new JMenuItem("Logout");
          menu1.add(i1);menu1.add(i5);    
          menu2.add(i6);
          menu3.add(i11); menu3.add(submenu);
          submenu.add(i15);submenu.add(i25);
          menu4.add(i16); 
          menu5.add(i20);
          mb.add(menu1); 
          mb.add(menu2); 
          mb.add(menu3); 
          mb.add(menu4); 
          mb.add(menu5);
          setJMenuBar(mb);  
}
            
    public void setLayoutManager(){
        container.setLayout(null);
        setBounds(10,10,370,600);
        setTitle("AdminPage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void setLocationAndSize(){
        Title.setBounds(150,50,100,30);
        Title.setFont(new Font("Verdana", Font.PLAIN, 18));
        userLabel.setBounds(50,100,100,30);
        passwordLabel.setBounds(50,150,100,30);
        Value.setBounds(50,200,100,30);
        c1.setBounds(150,100,150,30);
        c2.setBounds(150,150,150,30);
        valueField.setBounds(150,200,150,30);
        EditButton.setBounds(100,250,100,30);
    }
    
    public void addComponentsToContainer(){
        container.add(Title);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(c1);
        container.add(c2);
        container.add(valueField);
        container.add(Value);
        container.add(EditButton);
     }
         public void addActionEvent()
   {
       i1.addActionListener(this);
       i11.addActionListener(this);
       i16.addActionListener(this);
       c1.addActionListener(this);
       c2.addActionListener(this);
       EditButton.addActionListener(this);
       i20.addActionListener(this);
       i5.addActionListener(this);
       i15.addActionListener(this);
       i25.addActionListener(this);
   }
     
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==EditButton){
            String x = String.valueOf(c1.getSelectedItem());
            String y = String.valueOf(c2.getSelectedItem());
            admin obj = new admin();
            obj.editUser(x,y,valueField.getText());
            JOptionPane.showMessageDialog(this, "Edit Successful");
        }
        if(e.getSource()==i1){
            AddInfoTable obj1 = new AddInfoTable();
            dispose();
        }
        if(e.getSource()==i5){
            AddFinance obj5 = new AddFinance();
            dispose();
        }
        if(e.getSource()==i11){
            ViewInfoTable obj11 = new ViewInfoTable();
            dispose();
        }
        if(e.getSource()==i15){
            ViewFinance obj15 = new ViewFinance();
            dispose();
        }
        if(e.getSource()==i25){
            ViewMoreFinance obj25 = new ViewMoreFinance();
            dispose();
        }
        if(e.getSource()==i16){
            RemoveInfoTable obj16 = new RemoveInfoTable();
            dispose();
        }
        if(e.getSource()==i20){
            LoginFrame lgn = new LoginFrame();
            dispose();
        }
    }  
}

class RemoveInfoTable extends JFrame implements ActionListener{
    Container container=getContentPane();
    JMenu menu1,menu2,menu3,menu4,menu5,submenu;  
    JMenuItem i1, i5; 
    JMenuItem i6; 
    JMenuItem i11, i15,i25; 
    JMenuItem i16,i20;  
    JLabel Title=new JLabel("Delete");
    JLabel userLabel=new JLabel("USER :");
    UniversityManagement obj= new UniversityManagement();
    JComboBox c1 = new JComboBox(obj.userID);
    JButton RemoveButton=new JButton("Submit");
            
    RemoveInfoTable(){
        setmenu();
        setLayoutManager();
        addActionEvent();
        setLocationAndSize();
        addComponentsToContainer();
    }
    
        public void setmenu(){  
          JMenuBar mb=new JMenuBar();  
          menu1=new JMenu("Add");  
          menu2=new JMenu("Edit");
          menu3=new JMenu("View");
          menu4=new JMenu("Delete"); 
          menu5=new JMenu("Setting");
          submenu=new JMenu("Finance");
          i1=new JMenuItem("Information");  
          i5=new JMenuItem("Finance");  
          i6=new JMenuItem("Information"); 
          i11=new JMenuItem("Information"); 
          i15=new JMenuItem("Overall Finance"); 
          i25=new JMenuItem("Personal Finance");
          i16=new JMenuItem("Information"); 
          i20=new JMenuItem("Logout");
          menu1.add(i1);menu1.add(i5);    
          menu2.add(i6);
          menu3.add(i11); menu3.add(submenu);
          submenu.add(i15);submenu.add(i25);
          menu4.add(i16); 
          menu5.add(i20);
          mb.add(menu1); 
          mb.add(menu2); 
          mb.add(menu3); 
          mb.add(menu4); 
          mb.add(menu5);
          setJMenuBar(mb);  
}
            
    public void setLayoutManager(){
        container.setLayout(null);
        setBounds(10,10,370,600);
        setTitle("AdminPage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void setLocationAndSize(){
        Title.setBounds(150,50,100,30);
        Title.setFont(new Font("Verdana", Font.PLAIN, 18));
        userLabel.setBounds(50,100,100,30);
        c1.setBounds(150,100,150,30);
        RemoveButton.setBounds(100,250,100,30);
    }
    
    public void addComponentsToContainer(){
        container.add(Title);
        container.add(userLabel);
        container.add(c1);
        container.add(RemoveButton);
     }
         public void addActionEvent()
   {
       i1.addActionListener(this);
       i11.addActionListener(this);
       c1.addActionListener(this);
       RemoveButton.addActionListener(this);
       i6.addActionListener(this);
       i20.addActionListener(this);
       i5.addActionListener(this);
       i15.addActionListener(this);
       i25.addActionListener(this);
   }
     
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==RemoveButton){
            String x = String.valueOf(c1.getSelectedItem());
            admin obj = new admin();
            obj.removeUser(x);
            JOptionPane.showMessageDialog(this, "Remove Successful");
        }
        if(e.getSource()==i1){
            AddInfoTable obj1 = new AddInfoTable();
            dispose();
        }
        if(e.getSource()==i5){
            AddFinance obj5 = new AddFinance();
            dispose();
        }
        if(e.getSource()==i6){
            EditInfoTable obj6 = new EditInfoTable();
            dispose();
        }
        if(e.getSource()==i11){
            ViewInfoTable obj11 = new ViewInfoTable();
            dispose();
        }
        if(e.getSource()==i15){
            ViewFinance obj15 = new ViewFinance();
            dispose();
        }
        if(e.getSource()==i25){
            ViewMoreFinance obj25 = new ViewMoreFinance();
            dispose();
        }
        if(e.getSource()==i20){
            LoginFrame lgn = new LoginFrame();
            dispose();
        }
    }  
}

class WELCOME extends JFrame implements ActionListener{
    Container container=getContentPane();
    JMenu menu1,menu2,menu3,menu4,menu5,submenu;  
    JMenuItem i1, i5; 
    JMenuItem i6; 
    JMenuItem i11, i15,i25; 
    JMenuItem i16,i20; 
    JLabel Title=new JLabel("Welcome");
    
    WELCOME(){
        setmenu();
        setLayoutManager();
        addActionEvent();
        setLocationAndSize();
        addComponentsToContainer();
    }
        public void setmenu(){  
          JMenuBar mb=new JMenuBar();  
          menu1=new JMenu("Add");  
          menu2=new JMenu("Edit");
          menu3=new JMenu("View");
          menu4=new JMenu("Delete"); 
          menu5=new JMenu("Setting");
          submenu=new JMenu("Finance");
          i1=new JMenuItem("Information");  
          i5=new JMenuItem("Finance");  
          i6=new JMenuItem("Information"); 
          i11=new JMenuItem("Information"); 
          i15=new JMenuItem("Overall Finance"); 
          i25=new JMenuItem("Personal Finance");
          i16=new JMenuItem("Information"); 
          i20=new JMenuItem("Logout");
          menu1.add(i1);menu1.add(i5);    
          menu2.add(i6);
          menu3.add(i11); menu3.add(submenu);
          submenu.add(i15);submenu.add(i25);
          menu4.add(i16); 
          menu5.add(i20);
          mb.add(menu1); 
          mb.add(menu2); 
          mb.add(menu3); 
          mb.add(menu4); 
          mb.add(menu5);
          setJMenuBar(mb);    
}
        public void setLayoutManager(){
        container.setLayout(null);
        setBounds(10,10,600,600);
        setTitle("AdminPage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void setLocationAndSize(){
        Title.setBounds(200,200,300,40);
        Title.setFont(new Font("Verdana", Font.PLAIN, 40));
    }
    
    public void addComponentsToContainer(){
        container.add(Title);
     }

         public void addActionEvent()
   {
       i1.addActionListener(this);
       i6.addActionListener(this);
       i16.addActionListener(this);
       i11.addActionListener(this);
       i20.addActionListener(this);
       i5.addActionListener(this);
       i15.addActionListener(this);
       i25.addActionListener(this);
   }
     
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==i1){
            AddInfoTable obj1 = new AddInfoTable();
            dispose();
        }
        if(e.getSource()==i5){
            AddFinance obj5 = new AddFinance();
            dispose();
        }
        if(e.getSource()==i6){
            EditInfoTable obj6 = new EditInfoTable();
            dispose();
        }
        if(e.getSource()==i15){
            ViewFinance obj15 = new ViewFinance();
            dispose();
        }
        if(e.getSource()==i25){
            ViewMoreFinance obj25 = new ViewMoreFinance();
            dispose();
        }
        if(e.getSource()==i16){
            RemoveInfoTable obj16 = new RemoveInfoTable();
            dispose();
        }
         if(e.getSource()==i11){
            ViewInfoTable obj11 = new ViewInfoTable();
            dispose();
        }
         if(e.getSource()==i20){
            LoginFrame lgn = new LoginFrame();
            dispose();
        }
    }  
}


public class AdminCon {
    public static void main(String args[]){
        new LoginFrame();
    }
}
