package Project;
import Project.Login;
import java.util.ArrayList;

public class UniversityManagement{
    public static int unique_id = 0;
    public static String[] userID = new String[100];
    public static String[] password = new String[100];
    public static String[] fullName = new String[100];
    public static String[] phonenumber = new String[100];
    public static String[] address = new String[100];
    public static String[] position = new String[100];
    public static int abc=0;
        
    public static void main(String args[]){
       new LoginFrame();
    }
}
class admin{
    public String username = "admin";
    public String password = "admin123";

    
        public void addUser(String id,String pas,String usr,String phnm,String adrs,String pos) {
        UniversityManagement.userID[UniversityManagement.unique_id] = id;
        UniversityManagement.fullName[UniversityManagement.unique_id] = usr;
        UniversityManagement.password[UniversityManagement.unique_id] = pas;
        UniversityManagement.phonenumber[UniversityManagement.unique_id] = phnm;  
        UniversityManagement.address[UniversityManagement.unique_id] = adrs;
        UniversityManagement.position[UniversityManagement.unique_id] = pos;
        UniversityManagement.unique_id++;
    }
        public void view(){
              String s="";
       for(int i=0;i<UniversityManagement.unique_id;i++){
           System.out.println("ID: "+UniversityManagement.userID[i]+"| Name: "+UniversityManagement.fullName[i]+"| Password: "+UniversityManagement.password[i]+"| Phonenumber: "+UniversityManagement.phonenumber[i]+"| Address: "+UniversityManagement.address[i]);
       }
        }
        
        public void editUser(String id,String select,String value){
            for(int i=0;i<UniversityManagement.unique_id;i++){
            if(id.equals(UniversityManagement.userID[i])){
                switch(select){
                    case "UserID":  UniversityManagement.userID[i] = value;
                                    break;
                    case "Password":UniversityManagement.password[i] = value; 
                                    break;
                    case "Name":    UniversityManagement.fullName[i] = value;  
                                    break;
                    case "Phonenumber" :UniversityManagement.phonenumber[i] = value; 
                                    break;
                    case "address":UniversityManagement.address[i] = value;
                                    break;
                    default:   break;             
                }
            }
        }
        }
        
        public void removeUser(String id){
            for(int i=0;i<UniversityManagement.unique_id;i++){
                if(id.equals(UniversityManagement.userID[i])){
                    UniversityManagement.unique_id--;
                    for (int x = i; x <= UniversityManagement.userID.length ; x++) {
                    UniversityManagement.userID[x] = UniversityManagement.userID[x + 1];
                    UniversityManagement.fullName[x] = UniversityManagement.fullName[x + 1]; 
                    UniversityManagement.password[x] = UniversityManagement.password[x + 1]; 
                    UniversityManagement.phonenumber[x] = UniversityManagement.phonenumber[x + 1]; 
                    UniversityManagement.address[x] = UniversityManagement.address[x + 1]; 
                    UniversityManagement.position[x] = UniversityManagement.position[x + 1]; 
            }
                    break;
                }
        }
        }
        
        public void AddFinance(String id,float cost){
            int a=0;
            for(int i=0;i<UniversityManagement.unique_id;i++){
                if(id.equals(UniversityManagement.userID[i])){
                    a=i;
                }
            }
            int b=studentManagement.FinanceCount[a];
            studentManagement.Finance[a][b] = cost;
            studentManagement.FinanceCount[a]++;
        }

        
}

class studentManagement extends UniversityManagement{
    public static float[][] Finance = new float[100][100];
    public static int[] FinanceCount = new int[100];
    public static int StudentNo;
    
    public int StudentValidation(String id,String psd){
        for(int i=0;i<unique_id;i++){
                if(id.equals(userID[i])){
                    if(psd.equals(password[i])){
                        if(position[i].equals("Student")){
                            StudentNo = i;
                            return 1;
                        }
                        return 2;
                    }     
                }
        }
    return 0;
    }
}

class staffManagement extends UniversityManagement{
public static int StaffNo;    
    
    public int StaffValidation(String id,String psd){
        for(int i=0;i<unique_id;i++){
                if(id.equals(userID[i])){
                    if(psd.equals(password[i])){
                        if(position[i].equals("Staff")){
                            StaffNo = i;
                            return 1;
                        }
                        return 2;
                    }     
                }
        }
    return 0;
    }
}