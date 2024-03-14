import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Savings {
    
    static Connection con;
    static Statement stmt;
    static ResultSet rs;
    static PreparedStatement ps;
    Savings(String n,int a)throws Exception{
        System.out.println("saving");
         String url="jdbc:mysql://localhost:3306/mybank";
          String username="root";
          String password="Vssa13@1";
          Class.forName("com.mysql.cj.jdbc.Driver");
          con=DriverManager.getConnection(url, username, password);
          stmt=con.createStatement();
          this.Bal(a);
          Menu obj= new Menu();
          obj.Welcome(n, a);
    }
    public void Bal(int a)throws Exception{
        String query="SELECT * FROM transaction WHERE tid="+a;
        rs=stmt.executeQuery(query);
        float totd=0f;
        float totw=0f;
        while (rs.next()) {
            totd+=rs.getFloat("deposit");
            
        }
        rs=stmt.executeQuery(query);
        while (rs.next()) {
            totw+=rs.getFloat("withdraw");
            
        }
        float balance=totd-totw;
        System.out.println("Your Current Balance is: "+balance);
        
    }
}
