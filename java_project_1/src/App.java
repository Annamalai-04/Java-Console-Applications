
import java.util.Scanner; 
public class App extends UserValidation{
   
   Scanner sc=new Scanner(System.in);
   
       App() throws Exception{
        System.out.println("---------------------------------");
        System.out.println("\t Welcome to mybank\t");
        System.out.println("-----------------------------------");
        System.out.println();
       System.out.println("-----New User Press\t=> N ");
       System.out.println("-----New User Press\t=> O ");
       System.out.println("-----EXIT Bank Press\t=> Y ");
      System.out.println();
      System.out.print("-----enter your choice : ");
       char ch=sc.next().charAt(0);
       if(ch=='n'||ch=='N'){
      super.NewUser();
      }
       else if(ch=='O'||ch=='o'){
          super.OldUser();
        }
      else if(ch=='y'||ch=='Y'){
        System.out.println("XXXXXX EXITED XXXXX");
      }
      else {System.out.println("invalid Input!! Retry ");
             new App();}
     }
     
    public static void main(String[] args) throws Exception {
                 new App();
                
              
    }
}
