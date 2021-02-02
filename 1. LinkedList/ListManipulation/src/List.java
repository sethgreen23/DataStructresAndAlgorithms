public class List {
    
    private Node start;
    public static void main(String args[]) {
      List l = new List();
      l.add(1);
      l.add(2);
      l.add(8);
      l.print();
      Node removeItem=l.delete();
      System.out.println(removeItem.data);
      l.print();
      
    }
    public  void add(int n){
            start = new Node(n,start);
    }
    public  void print(){
        if(start == null || start.next==null){
            throw new IllegalStateException("List need to have more then one item");
        }
        
        Node parse = start;
        System.out.printf("{%s",parse.data);
        parse=parse.next;
        while(parse!=null){
            System.out.printf(", %s",parse.data);
            parse=parse.next;
        }
        System.out.println("}");
    }
    public  Node delete(){
        if(start == null || start.next==null){
            throw new IllegalStateException("List need to have more then one item");
        }
        
        Node removeItem = new Node(start.data,null);
        start = start.next;
        return removeItem;
    }
    
    
  public  void delete(int key) 
    { 
        // Store head node 
        Node temp = start, prev = null; 
  
        // If head node itself holds the key to be deleted 
        if (temp != null && temp.data == key) 
        { 
            start = temp.next; // Changed head 
            return; 
        } 
  
        // Search for the key to be deleted, keep track of the 
        // previous node as we need to change temp.next 
        while (temp != null && temp.data != key) 
        { 
            prev = temp; 
            temp = temp.next; 
        }     
  
        // If key was not present in linked list 
        if (temp == null) return; 
  
        // Unlink the node from linked list 
        prev.next = temp.next; 
    }  /* */
    
    
    
    
    static class Node{
        int data;
        Node next;
        
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
        
        Node(int data){
            this.data = data;
        }
    
    }
}