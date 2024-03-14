package mybank;





import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class bank extends user {
    Scanner sc=new Scanner(System.in);
     static LinkedList ids=new LinkedList<Integer>();
    static LinkedList names=new LinkedList<String>();
    static LinkedList passwords=new LinkedList<String>();
   

    public void defaultUser(){
        ids.add(101);
          names.add("annamalai");
          passwords.add("12345");
    }
    public void display(Object[] b1,Object[] b2,Object[] b3,int amt,String dt,Object iamt)throws Exception{
        
       System.out.println("-----------------------------------------------------");
         System.out.print("New User Y or N: ");
         char ch=sc.next().charAt(0);
         if(ch=='y'|| ch=='Y'){newUser(amt,dt,iamt);}
         if(ch=='n'|| ch=='N'){OldUser(amt,dt,iamt);}
         else{System.out.println("------------------------invalid");
               System.out.println(); display(b1,b2,b3,amt,dt,iamt);}
    }
    public void newUser(int amt,String dt,Object iamt) throws Exception{
        System.out.println("-------------------------------------------------------------");
        System.out.println("\t\twelcome to mybank\t\t");
        System.out.print("\tCreate id: ");
        int a=sc.nextInt();
        System.out.print("\tCreate UserName: ");
        String s1=sc.next();
        System.out.print("\tCreate Password: ");
        String s2=sc.next();
        ((HashMap) iamt).put(a,500);
        ids.add(a);
        names.add(s1);
        passwords.add(s2);
        Object[] a1=ids.toArray();
        Object[] a2=names.toArray();
        Object[] a3=passwords.toArray();
        System.out.println();
        super.menu(a1,a2,a3,a,s1,s2,amt,dt,iamt);
       
    }
    public void OldUser(int amt,String dt,Object iamt) throws Exception{
       
        System.out.println("--------------------------------------------------------------");
        System.out.println("\t\twelcome Back to mybank\t\t");
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.print("\tEnter id: ");
        int id=sc.nextInt();
        System.out.print("\tEnter Name: ");
        String name=sc.next();
        System.out.print("\tEnter Password: ");
        String psd=sc.next();
        Object[] a1=ids.toArray();
        Object[] a2=names.toArray();
        Object[] a3=passwords.toArray();
        if(ids.contains(id) && name.contains(name) && passwords.contains(psd)){
            System.out.println();
            super.menu(a1,a2,a3,id,name,psd,amt,dt,iamt);
        }
        else{
            System.out.println("--------------------incorrect details!!!");
            System.out.println();
            display(a1, a2, a3, amt,dt,iamt);
        }

}

public static void main(String[] args)throws Exception {
     LocalDateTime d = LocalDateTime.now();
     DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
     String dt = d.format(ft);
    bank obj=new bank();
    obj.defaultUser();
    Object[] a1=ids.toArray();
    Object[] a2=names.toArray();
    Object[] a3=passwords.toArray();
    LinkedHashMap iamt=new LinkedHashMap<>();
    iamt.put(101, 1000);
    obj.display(a1,a2,a3,1000,dt,iamt);
   
}
}
