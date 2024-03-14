import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Deposit {
    
    static Connection con;
    static Statement stmt;
    static ResultSet rs;
    static PreparedStatement ps;
    Scanner sc=new Scanner(System.in);
    Deposit(String n,int a)throws Exception{
        System.out.println("DEPOSIT");
         String url="jdbc:mysql://localhost:3306/mybank";
          String username="root";
          String password="Vssa13@1";
          Class.forName("com.mysql.cj.jdbc.Driver");
          con=DriverManager.getConnection(url, username, password);
          stmt=con.createStatement();
          this.Bal(a);
          this.UserDeposit(a);
          this.Bal(a);
         Menu obj= new Menu();
         obj.Welcome(n, a);
    }
    public void UserDeposit(int a)throws Exception{
        System.out.print("Deposit Amount: ");
        float amt=sc.nextFloat();
        String query="INSERT INTO transaction  VALUES(?,?,?,CURDATE(),CURTIME())";
        ps=con.prepareStatement(query);
        ps.setInt(1, a);
        ps.setFloat(2, amt);
        ps.setFloat(3, 0);
        
        ps.executeUpdate();
        System.out.println("Amount Successfully Deposited!!!");
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
        System.out.println("Your Balance is: "+balance);
        
    }
}
