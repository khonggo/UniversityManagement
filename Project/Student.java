package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Project.Login;
import Project.UniversityManagement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

class StudentMain extends JFrame implements ActionListener{
    Container container=getContentPane();
    JMenu menu1,menu2;  
    JMenuItem i1, i5; 
    JMenuItem i20; 
    studentManagement sm=new studentManagement();
    JLabel Name=new JLabel(sm.fullName[sm.StudentNo]);
    JLabel Title=new JLabel("Welcome");
    JButton B1=new JButton("ViewInformation");
    JButton B5=new JButton("ViewFinance");
    
    StudentMain(){
        setmenu();
        setLayoutManager();
        addActionEvent();
        setLocationAndSize();
        addComponentsToContainer();
    }
        public void setmenu(){  
          JMenuBar mb=new JMenuBar();  
          menu1=new JMenu("View");  
          menu2=new JMenu("Setting");
          i1=new JMenuItem("Information");   
          i5=new JMenuItem("Finance");  
          i20=new JMenuItem("Logout");
          menu1.add(i1); menu1.add(i5);    
          menu2.add(i20);
          mb.add(menu1); 
          mb.add(menu2); 
          setJMenuBar(mb);  
}
        public void setLayoutManager(){
        container.setLayout(null);
        setBounds(10,10,600,600);
        setTitle("StudentPage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void setLocationAndSize(){
        Title.setBounds(200,100,300,40);
        Title.setFont(new Font("Verdana", Font.PLAIN, 40));
        Name.setBounds(180,200,300,30);
        Name.setFont(new Font("Verdana", Font.PLAIN, 35));
        B1.setBounds(200,250,200,30);
        B5.setBounds(200,350,200,30);
    }
    
    public void addComponentsToContainer(){
        container.add(Title);
        container.add(B1);
        container.add(B5);
        container.add(Name);
     }

         public void addActionEvent()
   {
       i1.addActionListener(this);
       i5.addActionListener(this);
       i20.addActionListener(this);
       B1.addActionListener(this);
       B5.addActionListener(this);
   }
     
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==i1){
            StudentViewInfo svi = new StudentViewInfo();
            dispose();
        }
        if(e.getSource()==B5){
            StudentViewFinance svf = new StudentViewFinance();
            dispose();
        }
        if(e.getSource()==i5){
            StudentViewFinance svf = new StudentViewFinance();
            dispose();
        }
         if(e.getSource()==i20){
            LoginFrame lgn = new LoginFrame();
            dispose();
        }
         if(e.getSource()==B1){
            StudentViewInfo svi = new StudentViewInfo();
            dispose();
        }
    } 
}

class StudentViewInfo extends JFrame implements ActionListener{
    Container container=getContentPane();
        JMenu menu1,menu2,menu3;  
        JMenuItem i1, i5; 
        JMenuItem i20,home; 
        
        java.util.List<String> columns = new ArrayList<String>();
        java.util.List<String[]> values = new ArrayList<String[]>();
    
    StudentViewInfo(){
        setmenu();
        setBounds(10,10,1060,600);
        setTitle("StudentPage");
        setTable();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addActionEvent();
    }
        public void setmenu(){  
          JMenuBar mb=new JMenuBar();  
          menu1=new JMenu("View");  
          menu2=new JMenu("Setting");
          menu3=new JMenu("Home");
          i1=new JMenuItem("Information");  
          i5=new JMenuItem("Finance");  
          i20=new JMenuItem("Logout");
          home=new JMenuItem("Home");        
          
          menu1.add(i1); menu1.add(i5);    
          menu2.add(i20);
          menu3.add(home);
          menu3.add(menu1);
          mb.add(menu3); 
          mb.add(menu2); 
          setJMenuBar(mb);  
}
        
    public void setTable(){
            studentManagement sm= new studentManagement();

            columns.add("UserID");
            columns.add("Password");
            columns.add("FullName");
            columns.add("Phonenumber");
            columns.add("Address");
            columns.add("Position");
            values.add(new String[] {sm.userID[sm.StudentNo],sm.password[sm.StudentNo],sm.fullName[sm.StudentNo],sm.phonenumber[sm.StudentNo],sm.address[sm.StudentNo],sm.position[sm.StudentNo]});

            TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
            JTable table = new JTable(tableModel);
            add(new JScrollPane(table), BorderLayout.CENTER);
            add(table.getTableHeader(), BorderLayout.NORTH);
          
    }
    

         public void addActionEvent()
   {
       i20.addActionListener(this);
       i5.addActionListener(this);
       home.addActionListener(this);
   }
     
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==i20){
            LoginFrame lgn = new LoginFrame();
            dispose();
        }
        if(e.getSource()==i5){
            StudentViewFinance svf = new StudentViewFinance();
            dispose();
        }
        if(e.getSource()==home){
            StudentMain obj = new StudentMain();
            dispose();
        }
    }  
}


class StudentViewFinance extends JFrame implements ActionListener{
    Container container=getContentPane();
        JMenu menu1,menu2,menu3;  
        JMenuItem i1, i2, i3, i4, i5; 
        JMenuItem i20,home; 
        
        java.util.List<String> columns = new ArrayList<String>();
        java.util.List<String[]> values = new ArrayList<String[]>();
    
    StudentViewFinance(){
        setmenu();
        setBounds(10,10,1060,600);
        setTitle("StudentPage");
        setTable();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addActionEvent();
    }
        public void setmenu(){  
          JMenuBar mb=new JMenuBar();  
          menu1=new JMenu("View");  
          menu2=new JMenu("Setting");
          menu3=new JMenu("Home");
          i1=new JMenuItem("Information");  
          i5=new JMenuItem("Finance");  
          i20=new JMenuItem("Logout");
          home=new JMenuItem("Home");        
          
          menu1.add(i1); menu1.add(i5);    
          menu2.add(i20);
          menu3.add(home);
          menu3.add(menu1);
          mb.add(menu3); 
          mb.add(menu2); 
          setJMenuBar(mb);  
}
        
    public void setTable(){

           studentManagement sm= new studentManagement();
            float Z=0; 
            columns.add("");
            columns.add("Finance Statment");
            for(int i=0;i<sm.FinanceCount[sm.StudentNo];i++){
                Z+=sm.Finance[sm.StudentNo][i];
            }
            for(int i=0;i<sm.FinanceCount[sm.StudentNo];i++){
                values.add(new String[] {"",String.valueOf(sm.Finance[sm.StudentNo][i])});
            }
            values.add(new String[] {"Total : ",String.valueOf(Z)});
            TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
            JTable table = new JTable(tableModel); 
            add(new JScrollPane(table), BorderLayout.CENTER);
            add(table.getTableHeader(), BorderLayout.NORTH);
    }
    

         public void addActionEvent()
   {
       i20.addActionListener(this);
       i1.addActionListener(this);
       home.addActionListener(this);
   }
     
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==i20){
            LoginFrame lgn = new LoginFrame();
            dispose();
        }
        if(e.getSource()==i1){
            StudentViewInfo svi = new StudentViewInfo();
            dispose();
        }
        if(e.getSource()==home){
            StudentMain obj = new StudentMain();
            dispose();
        }
    }  
}

public class Student {
    public static void main(String args[]){
         new LoginFrame();
    }
}
