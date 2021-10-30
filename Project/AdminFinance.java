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

class AddFinance extends JFrame implements ActionListener{
    Container container=getContentPane();
    JMenu menu1,menu2,menu3,menu4,menu5,submenu;  
    JMenuItem i1, i5; 
    JMenuItem i6; 
    JMenuItem i11, i15,i25; 
    JMenuItem i16,i20; 
    JLabel Title=new JLabel("ADD FINANCE");
    JLabel userLabel=new JLabel("USER :");
    JLabel Value = new JLabel("VALUE :");
    JTextField valueField=new JTextField();
    UniversityManagement obj= new UniversityManagement();
    JComboBox c1 = new JComboBox(obj.userID);
    JButton AddButton=new JButton("Submit");
            
    AddFinance(){
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
        Title.setBounds(100,50,200,30);
        Title.setFont(new Font("Verdana", Font.PLAIN, 18));
        userLabel.setBounds(50,100,100,30);
        Value.setBounds(50,200,100,30);
        c1.setBounds(150,100,150,30);
        valueField.setBounds(150,200,150,30);
        AddButton.setBounds(100,250,100,30);
    }
    
    public void addComponentsToContainer(){
        container.add(Title);
        container.add(userLabel);
        container.add(c1);
        container.add(valueField);
        container.add(Value);
        container.add(AddButton);
     }
         public void addActionEvent()
   {
       i1.addActionListener(this);
       i11.addActionListener(this);
       i15.addActionListener(this);
       i16.addActionListener(this);
       c1.addActionListener(this);
       i20.addActionListener(this);
       i25.addActionListener(this);
       AddButton.addActionListener(this);
   }
     
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==AddButton){
            String x = String.valueOf(c1.getSelectedItem());
            try{
                 Float.parseFloat(valueField.getText());
                 float f=Float.parseFloat(valueField.getText());
                 admin obj = new admin();
                 obj.AddFinance(x,f);
            JOptionPane.showMessageDialog(this, "Add Successful");
            }catch(NumberFormatException ee){
                 JOptionPane.showMessageDialog(this, "Please Enter number in value");
             }
        }
        if(e.getSource()==i1){
            AddInfoTable obj1 = new AddInfoTable();
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
        if(e.getSource()==i16){
            RemoveInfoTable obj16 = new RemoveInfoTable();
            dispose();
        }
        if(e.getSource()==i20){
            LoginFrame lgn = new LoginFrame();
            dispose();
        }
        if(e.getSource()==i25){
            ViewMoreFinance obj25= new ViewMoreFinance();
            dispose();
        }
    }  
}

class ViewFinance extends JFrame implements ActionListener{
    Container container=getContentPane();
    JMenu menu1,menu2,menu3,menu4,menu5,submenu;  
    JMenuItem i1, i5; 
    JMenuItem i6; 
    JMenuItem i11, i15,i25; 
    JMenuItem i16,i20; 
    java.util.List<String> columns = new ArrayList<String>();
    java.util.List<String[]> values = new ArrayList<String[]>();
    
    ViewFinance(){
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

           studentManagement obj= new studentManagement();
            float[] a = new float[obj.unique_id]; 
            columns.add("UserID");
            columns.add("TotalFinanceStatment");
            for(int i=0;i<obj.unique_id;i++){
                for(int j=0;j<100;j++){
                    a[i]+= obj.Finance[i][j];
                }
            }
            for(int i=0;i<obj.unique_id;i++){
                values.add(new String[] {obj.userID[i],String.valueOf(a[i])});
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
       i5.addActionListener(this);
       i6.addActionListener(this);
       i16.addActionListener(this);
       i20.addActionListener(this);
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
        if(e.getSource()==i16){
            RemoveInfoTable obj16 = new RemoveInfoTable();
            dispose();
        }
        if(e.getSource()==i20){
            LoginFrame lgn = new LoginFrame();
            dispose();
        }
        if(e.getSource()==i25){
            ViewMoreFinance obj25 = new ViewMoreFinance();
            dispose();
        }
    }  
}


class ViewMoreFinance extends JFrame implements ActionListener{
    Container container=getContentPane();
    JMenu menu1,menu2,menu3,menu4,menu5,submenu;  
    JMenuItem i1, i5; 
    JMenuItem i6; 
    JMenuItem i11, i15,i25; 
    JMenuItem i16,i20; 
    java.util.List<String> columns = new ArrayList<String>();
    java.util.List<String[]> values = new ArrayList<String[]>();
    JLabel Title=new JLabel("CHECK USER FINANCE");
    JLabel userLabel=new JLabel("USER :");
    UniversityManagement obj= new UniversityManagement();
    JComboBox c1 = new JComboBox(obj.userID);
    JButton CheckButton=new JButton("Submit");
    
    ViewMoreFinance(){
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
        setBounds(10,10,1060,600);
        setTitle("AdminPage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void setLocationAndSize(){
        Title.setBounds(50,50,300,30);
        Title.setFont(new Font("Verdana", Font.PLAIN, 18));
        userLabel.setBounds(50,100,100,30);
        c1.setBounds(150,100,150,30);
        CheckButton.setBounds(100,250,100,30);
    }
    
    public void addComponentsToContainer(){
        container.add(Title);
        container.add(userLabel);
        container.add(c1);
        container.add(CheckButton);
     }
         public void addActionEvent()
   {
       i1.addActionListener(this);
       i5.addActionListener(this);
       i6.addActionListener(this);
       i16.addActionListener(this);
       i20.addActionListener(this);
       i15.addActionListener(this);
       CheckButton.addActionListener(this);
   }
     
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==CheckButton){
            studentManagement obj= new studentManagement();
            float Z=0; 
            columns.add("");
            columns.add("Finance Statment");
            int a=0;
            String x = String.valueOf(c1.getSelectedItem());
            for(int i=0;i<obj.unique_id;i++){
                if(x.equals(obj.userID[i])){
                    a=i;
                    break;
                }
            }
            for(int i=0;i<obj.FinanceCount[a];i++){
                Z+=obj.Finance[a][i];
            }
            for(int i=0;i<obj.FinanceCount[a];i++){
                values.add(new String[] {"",String.valueOf(obj.Finance[a][i])});
            }
            values.add(new String[] {"Total : ",String.valueOf(Z)});
            TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
            JTable table = new JTable(tableModel); 
            JScrollPane sp=new JScrollPane(table); 
            sp.setBounds(500,0,550,600);
            add(sp);   
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
        if(e.getSource()==i15){
            ViewFinance obj15 = new ViewFinance();
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

public class AdminFinance {
    public static void main(String args[]){
        new LoginFrame();
    }
}
