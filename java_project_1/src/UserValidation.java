import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class UserValidation extends Menu  {
    
      static Connection con;
     static Statement stmt;
     static ResultSet rs;
     static PreparedStatement ps;
     Scanner sc=new Scanner(System.in);
     static int uno;
     static String uname;
     static String upsd;
     
     UserValidation() throws ClassNotFoundException, SQLException
     {
          String url="jdbc:mysql://localhost:3306/mybank";
          String username="root";
          String password="Vssa13@1";
          Class.forName("com.mysql.cj.jdbc.Driver");
          con=DriverManager.getConnection(url, username, password);
          stmt=con.createStatement();
          
     }
     void NewUser() throws Exception{
          System.out.println("new user");
          System.out.print("Create ID: ");
          int id=sc.nextInt();
          System.out.print("Create Name: ");
          String name=sc.next();
          System.out.print("Create Password: ");
          String psd=sc.next();
         this.DataInsert(id, name, psd);
    }
     void OldUser() throws Exception{
          System.out.println("old user");
          System.out.print("Enter ID: ");
          int id=sc.nextInt();
          System.out.print("Enter Name: ");
          String name=sc.next();
          System.out.print("Enter Password: ");
          String psd=sc.next();
          this.DataCheck(id, name, psd);
    }
     public void DataCheck(int a,String s1,String s2) throws Exception{
                UserValidation obj =new UserValidation();
                String query="SELECT * FROM user";
                rs=stmt.executeQuery(query);
                while (rs.next())
                {
                    uno= rs.getInt("uno");
                    uname=rs.getString("uname");
                    upsd=rs.getString("upsd");
                    if(uno==a && uname.equals(s1) && upsd.equalsIgnoreCase(s2)){
                         super.Welcome(uname,uno);
                    }
                    
                }
                if(rs.next()==false){
                    System.out.println("Incorrect Data!!!!");
                     new App();
                  }
               
                    
                

    }
    private void DataInsert(int a,String s1,String s2)throws Exception{
     UserValidation obj=new UserValidation();
     String query="INSERT INTO user VALUES(?,?,?)";
     ps=con.prepareStatement(query);
     ps.setInt(1, a);
     ps.setString(2, s1);
     ps.setString(3, s2);
     ps.executeUpdate();
     super.Welcome(s1,a);
 }
     
}


