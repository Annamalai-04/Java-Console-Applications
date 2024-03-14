import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Withdraw {
    
    static Connection con;
    static Statement stmt;
    static ResultSet rs;
    static PreparedStatement ps;
    static float balance;
    Scanner sc=new Scanner(System.in);
    Withdraw(String n,int a)throws Exception{
        System.out.println("WITHDRAW");
         String url="jdbc:mysql://localhost:3306/mybank";
          String username="root";
          String password="Vssa13@1";
          Class.forName("com.mysql.cj.jdbc.Driver");
          con=DriverManager.getConnection(url, username, password);
          stmt=con.createStatement();
          this.Bal(a,n);
          this.UserWithDraw(a,balance,n);
    }
    public void UserWithDraw(int a,float balance ,String n)throws Exception{
        System.out.print("Withdraw Amount: ");
        float amt=sc.nextFloat();
        if(amt<balance){
        String query="INSERT INTO transaction  VALUES(?,?,?,CURDATE(),CURTIME())";
        ps=con.prepareStatement(query);
        ps.setInt(1, a);
        ps.setFloat(2, 0);
        ps.setFloat(3, amt);
        ps.executeUpdate();
        System.out.println("Amount Successfully Withdrawn!!!");
        this.Bal(a,n);
        Menu obj= new Menu();
        obj.Welcome(n, a);
        }
        else{
            System.out.println("Insufficient balance!!!");
            this.UserWithDraw(a,balance,n);
        }
    }
    public void Bal(int a,String n)throws Exception{
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
        balance =totd-totw;
        System.out.println("Your Balance is: "+balance);
        
    }
}
