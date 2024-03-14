import java.util.Scanner;

public class Menu {
    Scanner sc=new Scanner(System.in);
    public void Welcome(String n,int a) throws Exception{
        System.out.println("---------- "+n+" -----------");
        System.out.println();
        System.out.println("\t 1. ---Deposit---");
        System.out.println("\t 2. ---Withdraw---");
        System.out.println("\t 3. ---Savings---");
        System.out.println("\t 4. ---Transactions---");
        System.out.println("\t 5. ---Exit---");
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        System.out.print("Enter Your Choice: ");
        int ch=sc.nextInt();
        switch (ch) {
            case 1:new Deposit(n,a);break;
            case 2:new Withdraw(n,a);break;
            case 3:new Savings(n,a);break;
            case 4:new Transaction(n,a);break;
            case 5:{System.out.println("---------Thank You of Using Our Bank-----------");
                    new App();}break;
            default:{System.out.println("invalid");
                    this.Welcome(n,a);}break;
        }
        
    }
}
