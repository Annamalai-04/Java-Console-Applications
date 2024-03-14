package mybank_copy;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class ThreeValues {
    private int value1;
    private int value2;

    public ThreeValues(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }
}

public class user {
    Scanner sc=new Scanner(System.in);
    static LinkedHashMap dp=new LinkedHashMap<String,Integer>();
    static LinkedHashMap wd=new LinkedHashMap<>();
   
    
    public void deposit(Object[] a1,Object[] a2,Object[] a3,int id,String n,String p,int amt,String dt,Object iamt) throws Exception{
          LocalDateTime d = LocalDateTime.now();
     DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
     String dtl = d.format(ft);
        System.out.println("Current Balance: "+((HashMap) iamt).get(id));
        System.out.print("Enter deposit amount: ");
        int dpt=sc.nextInt();
        dp.put(dtl,new ThreeValues(id,dpt));
        amt=(int) ((HashMap) iamt).get(id);
        amt+=dpt;
        ((HashMap) iamt).put(id, amt);
        System.out.println("Current Balance: "+((HashMap) iamt).get(id));
        this.menu(a1, a2,a3, id, n, p,amt,dt,iamt);
    }
   
    public void withdraw(Object[] a1,Object[] a2,Object[] a3,int id,String n,String p,int amt,String dt,Object iamt) throws Exception{
        LocalDateTime d = LocalDateTime.now();
        DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String wdl = d.format(ft);
        System.out.println("Current Balance: "+((HashMap) iamt).get(id));
        System.out.print("Enter withdraw amount: ");
        int wt=sc.nextInt();
        wd.put(wdl, new ThreeValues(id, wt));
        if(wt<amt){
            amt=(int) ((HashMap) iamt).get(id);
            amt-=wt;
            ((HashMap) iamt).put(id, amt);
            System.out.println("Current Balance: "+((HashMap) iamt).get(id));
            this.menu(a1, a2,a3, id, n, p,amt,dt,iamt);
        }
        else{
            System.out.println("insufficient balance");
            this.withdraw(a1, a2, a3, id, n, p, amt,dt,iamt);
        }

    }
   
    public void Savings(Object[] a1,Object[] a2,Object[] a3,int id,String n,String p,int amt,String dt,Object iamt)throws Exception{
        
        if(((HashMap) iamt).containsKey(id)){
            System.out.println("your current balance is :"+((HashMap) iamt).get(id));
            
        }
        System.out.println(iamt);

       
        
        this.menu(a1, a2,a3, id, n, p,amt,dt,iamt);
       
    }
    
    public void transaction(Object[] a1,Object[] a2,Object[] a3,int id,String n,String p,int amt,String dt,Object iamt) throws Exception{
        System.out.println("deposits");
       
        for (Object entry : dp.entrySet()) {
            Map.Entry<String, ThreeValues> typedEntry = (Map.Entry<String, ThreeValues>) entry;
            String key = typedEntry.getKey();
            ThreeValues values = typedEntry.getValue();
            if(values.getValue1()==id){
            System.out.println("DateTime: " + key + ", UserID: " + values.getValue1() + ", Amount: " + values.getValue2());
            }
        }
        System.out.println("withdraws");
        for (Object entry : wd.entrySet()) {
            Map.Entry<String, ThreeValues> typedEntry = (Map.Entry<String, ThreeValues>) entry;
            String key = typedEntry.getKey();
            ThreeValues values = typedEntry.getValue();
            if(values.getValue1()==id){
            System.out.println("Key: " + key + ", Value1: " + values.getValue1() + ", Value2: " + values.getValue2());
            }
        }
        this.menu(a1, a2,a3, id, n, p,amt,dt,iamt);
}

  public void menu(Object[] a1,Object[] a2,Object[] a3,int id,String n,String p,int amt,String dt,Object iamt) throws Exception{
    // for (Object i : a1) {
    //    System.out.print(i+" ");
    // }
    // System.out.println();
    // for (Object i : a2) {
    //    System.out.print(i+" ");
    // }
    // System.out.println();
    // for (Object i : a3) {
    //    System.out.print(i+" ");
    // }
    // System.out.println();
   
    System.out.println("-------Welcome "+n+"  --------");
    System.out.println("1. for Deposit");
    System.out.println("2. for Withdraw");
    System.out.println("3. for Savings");
    System.out.println("4. for Transaction history");
    System.out.println("5. for EXIT");
    System.out.print("Enter Your Choice: ");
    int ch=sc.nextInt();
    switch (ch) {
        case 1:deposit(a1,a2,a3,id,n,p,amt,dt,iamt);break;
        case 2:withdraw(a1,a2,a3,id,n,p,amt,dt,iamt);break;
        case 3:Savings(a1,a2,a3,id,n,p,amt,dt,iamt);break;
        case 4:transaction(a1,a2,a3,id,n,p,amt,dt,iamt);break;
        case 5:System.out.println("Thankyou");
               bank obj=new bank();
               obj.display(a1,a2,a3,amt,dt,iamt);
                break;
        default:System.out.println("invalid");
                
            break;
    }
}
}