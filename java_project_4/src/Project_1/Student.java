package Project_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Student {
    Connection con;
    Statement stmt;
    Student() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Vssa13@1");
       stmt=con.createStatement();
        
    }
    public void createStd() throws Exception{
        System.out.println("create");
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER ROLLNO: ");
        int no=sc.nextInt();
        System.out.print("ENTER NAME: ");
        String name=sc.next();
        System.out.print("ENTER AGE: ");
        int ag=sc.nextInt();
        System.out.print("ENTER OLD SCHOOL ");
        String oschl=sc.next();
        System.out.print("ENTER DEPARTMENT: ");
        String depart=sc.next();
        String query="INSERT INTO sms VALUES(?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1, no);
        ps.setString(2, name);
        ps.setInt(3, ag);
        ps.setString(4, oschl);
        ps.setString(5, depart);
        int ins=ps.executeUpdate();
        System.out.println("-----------------------------------");
        System.out.println("one row successfully inserted!!!!!");
        System.out.println("-----------------------------------");
        App b=new App();
    }
    public void viewbyno()throws Exception{
        System.out.println("Access data using rollno");
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER ROLLNO: ");
        int no=sc.nextInt();
        String query="SELECT * FROM sms WHERE rno="+no;
        ResultSet rs=stmt.executeQuery(query);
        while (rs.next()) {
            String disp=rs.getInt("rno")+" "+rs.getString("sname")+" "+rs.getInt("age")+" "+rs.getString("old_scl")+" "+rs.getString("dept");
            System.out.println(disp);
        }
        App b=new App();
    }
    public void viewbyschool()throws Exception{
        System.out.println("Access data using old school");
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER OLD SCHOOL NAME: ");
        String oname=sc.next();
        String query="SELECT * FROM sms WHERE old_scl='"+oname+"'";
        ResultSet rs=stmt.executeQuery(query);
        while (rs.next()) {
            String disp=rs.getInt("rno")+" "+rs.getString("sname")+" "+rs.getInt("age")+" "+rs.getString("old_scl")+" "+rs.getString("dept");
            System.out.println(disp);
        }  
        App b=new App();
    }
    public void deletebyid()throws Exception{
        System.out.println("delete data using rollno");
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER ROLL NO: ");
        int no=sc.nextInt();
        String query="DELETE FROM sms WHERE rno="+no;
        stmt.executeUpdate(query);
        System.out.println("-----------------------------------");
        System.out.println("one row successfully deleted!!!!!");
        System.out.println("-----------------------------------");
        App b=new App();
    }
    public void updatebyid()throws Exception{
        System.out.println("update rno data using student_name");
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER STUDENT NAME: ");
        String name=sc.next();
        String q="select rno from sms where sname='"+name+"'";
        ResultSet rs=stmt.executeQuery(q);
        rs.next();
        int rollno=rs.getInt("rno");
        System.out.println("Old RollNo is : "+rollno);
        System.out.print("SET NEW ROLL NO: ");
        int no=sc.nextInt();
        String query="UPDATE sms SET rno=(?) WHERE sname=(?)";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setInt(1, no);
        ps.setString(2, name);
        ps.executeUpdate();
        System.out.println("-----------------------------------");
        System.out.println("one row successfully Updated!!!!!");
        System.out.println("-----------------------------------");
        App b=new App();
    }
}
