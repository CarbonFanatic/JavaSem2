 package finalproject;

import java.io.*;
import java.util.Scanner;





public class test {
    
     public static void main(String[] args) {
        // TODO code application logic here
        
       birds b1 = new birds();
       
         try {  
            File adds = new File("test1.txt");
	    File remove = new File ("test_2.txt");
       
           Scanner Add = new Scanner(adds);
                       while(Add.hasNext()){
                        String BdName=Add.nextLine();
                               
                           b1.search(BdName);
                                
                            }
                        
                        System.out.println(b1.toString());
       
                     
     System.out.println("-----------------------");
           System.out.println("sorted");
                    b1.sort();
                      
                  Scanner Rm = new Scanner(remove);
                            while(Rm.hasNext()){
                                String rdName=Rm.nextLine();
                                b1.removeBird(rdName);          
                            }
                        System.out.println(b1.toString());
                }
                      catch(IOException e){
                          System.err.println(e.getMessage());
                      }
            }
     }
          
                    
                    
        
        
       
 

