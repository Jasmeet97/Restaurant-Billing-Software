/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurant.billing.software;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.lang.*;

class Menu
{
    String[] dish_name = {"Vada Pav", "Shev Puri","Samosa","Rasmalai"};
    int[] dish_amt = {20,25,23,50};
}

public class RestaurantBillingSoftware {
    
    public static void main(String[] args) 
    {
            Menu m=new Menu();
		System.out.println("| Sl no    |             Item             |");
                 
		System.out.println("|-----------------------------------------|");
                 
		for(int i=0;i<m.dish_name.length;i++)         
                {if(m.dish_name[i]!=null)
                {System.out.println("| "+m.dish_name[i]+"        |            "+"Rs"+m.dish_amt[i]+"    |");
                 
		System.out.println("|-----------------------------------------|");
                 }}
                 
		System.out.println("|-----------------------------------------|");
                 
		 
                // close connection
        getOrder or=new getOrder();
        or.makeOrder();
    
    }
    
}
class getOrder extends Menu
{
    int tb_no,ch,n=0,amt=0;
    boolean flag=true;
    String order=new String();
    String name;//[]=new String[20];
   static String c[]=new String[10];
   static double cn[]=new double[10];
    
    
    void makeOrder()
    {
        System.out.println("Enter the table number:");
        Scanner in=new Scanner(System.in);
        tb_no=in.nextInt();
        
        while(flag!=false)
        {
            System.out.println("1.place order\n2.Quit and print bill\nEnter the choice");
            ch=in.nextInt();
            
            switch(ch)
            {
                case 1: System.out.println("Enter the dish name:");
                        Scanner input=new Scanner(System.in);
                        name=input.nextLine();
                        retVal(name);
                        for(int i=0;i<n;i++)
                            System.out.println(c[n]+"  "+cn[n]);
                        break;
                case 2: try{
             File file = new File("bill.txt");

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("|-----------------------------------------|\n");
                bw.newLine();
		bw.write("|   Bill number " +n+"                        |");
                bw.newLine();
		bw.write("|-----------------------------------------|");
                bw.newLine();
		bw.write("| Sl no    |             Item             |");
                bw.newLine();
		bw.write("|-----------------------------------------|");
                bw.newLine();
		for(int i=0;i<cn.length;i++)         
                {if(c[i]!=null)
                {bw.write("| "+c[i]+"        |            "+"Rs"+cn[i]+"    |");
                bw.newLine();
		bw.write("|-----------------------------------------|");
                bw.newLine();}}
		bw.write("| R        | Total               "+amt+"    |");
                bw.newLine();
		bw.write("|-----------------------------------------|");
                bw.newLine();
		 
                // close connection
                bw.close();
          }catch(Exception e){
              System.out.println(e);
          }           
                flag=false;
                       break;
                //case 3:for(int q=0;q<i;q++)
                  //          System.out.println(cn[q]);
                default:System.out.println("Enter the valid choice");
            }
        }
        
    }
    
    void retVal(String name)
    {
         for(int i=0;i<dish_name.length;i++)
                        { 
                            if(name.equals(dish_name[i]))
                            {
                                c[n]=name;
                                cn[n]=dish_amt[i];
                                
                                n++;
                                amt+=dish_amt[i];
                                
                            }
                        }
    }
}