/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
/**
 *
 * @author 1410299
 */
public class birds {

    private class birdNode {
        int frequency;
        String name;
        birdNode next;
        birdNode (String n) {
            name=n;
            frequency = 1;
            next = null;
            
        }
        
    }  
    private birdNode first=null;
    private birdNode last;
 
    
    public void addFirst(String e){
        birdNode toAdd = new birdNode(e);
        
        toAdd.next=first;
        first=toAdd;
       
    }
        public void addLast(String e){
            birdNode toAdd = new birdNode (e);
            birdNode p=first;
            while(p!=null)
                p=p.next;
            
            p.next=toAdd;
        }
    
    public void removeFirst(){
            first=first.next;
        }
    
    public void removeLast(){
            birdNode temp = first;
            birdNode prev = temp;
            if(size()==1) {
                first = first.next;
            return;
            }
            if(size()==0)
                    return;
             
            while(temp.next!=null){
                prev = temp;
                temp = temp.next;
            }
            prev.next = null; 
                
        }
    
    public  void removeall(){
        first = null;
    }
    
          public boolean isEmpty(){
            return first == null;
        }
            public int size() {
            int size=0;
            birdNode p=first;
            while(p!=null){
                size++;
                p=p.next;
                }
            return size;
        }
            
   
       public void search (String element){         
            boolean found=false;
            
            if(isEmpty()){
               addFirst(element);
               return;
            }
            if(first.name.equals(element)){
                first.frequency++;
                return;
            }
            
            birdNode p= first;
              
           while(p!=null && !found){
               
               if (p.name.equals(element))
               {
                 found=true;  
                 p.frequency++;
               }
               p=p.next;
           }
           if (!found)
               addFirst(element);
        }
             
             
             
             
       public void sort(){
          
       for(birdNode ref=first;ref!=null;ref=ref.next){
           
           birdNode highRef = ref;
           
           for(birdNode ref2=ref.next;ref2!=null;ref2=ref2.next){
               
               if(ref2.frequency>highRef.frequency){
                   
                  highRef=ref2;  
               }           
            }
            //Swap
               int temp = highRef.frequency;
               highRef.frequency=ref.frequency;
               ref.frequency=temp;

               String tempvalue = highRef.name;
               highRef.name=ref.name;
               ref.name=tempvalue;
   }
   }
   
      public void removeBird(String n){
           boolean found = false;
            if(isEmpty())
                return;

            birdNode temp = first;
            birdNode prev = null;
            
            while(temp!=null && !found){
                if(n.equals(temp.name)){
                    if(prev==null){
                        removeFirst();
                        return;
                    }
                    if(temp.next == null){
                        removeLast();
                        return;
                    }  
                    prev.next = prev.next.next;  
                    
                }
                prev = temp;
                temp = temp.next;
            }
        }
        @Override
        public String toString(){
            String str="";
            birdNode p=first;
            while(p!=null)
            {
                str+= "'" + p.name+ "'"+": "+p.frequency  + "\n";
                p=p.next;
            }
            return str;
        }
        
   
}
