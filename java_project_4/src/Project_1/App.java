package Project_1;

import java.util.Scanner;

public class App extends Student  {
    App() throws Exception {
       
        System.out.println("---------------------------------------------------");
        System.out.println("----------Welcome to ST.THOMAS SCHOOL--------------");
        System.out.println();
        System.out.println("\t1.\t --------Create New Student-------");
        System.out.println("\t2.\t --------View Student by Rollno-------");
        System.out.println("\t3.\t --------View Student by Old School-------");
        System.out.println("\t4.\t --------Delete Student by Rollno---------");
        System.out.println("\t5.\t --------Update Student Rollno by name---------");
        System.out.println("\t6.\t XXXXXXXXXExit applicationXXXXXXXXX");
        System.out.println();
        System.out.println("-----------------------------------------------------");
        Scanner sc=new Scanner(System.in);
        System.out.print("enter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:super.createStd();break;
            case 2:super.viewbyno();break;
            case 3:super.viewbyschool();break;
            case 4:super.deletebyid();break;
            case 5:super.updatebyid();break;
            case 6:System.out.println("----Have a nice day---");break;
            default:break;
        }
    }
    public static void main(String[] args)throws Exception {
        App a=new App();
    }
}
