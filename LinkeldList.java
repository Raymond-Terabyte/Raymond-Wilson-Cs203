class LinkedList 
{ 
    Node head;  
  
    class Node 
    { 
        int num; 
        Node next; 
        Node(int n) 
        { 
            num = n; 
            next = null; 
        } 
    }  
    public void push(int new_num) 
    { 
            Node new_node = new Node(new_num); 
  
        new_node.next = head; 
        head = new_node; 
    } 
    void deleteNode(int position) 
    { 

        if (head == null) 
            return; 
  
        Node temp = head; 
  
        if (position == 0) 
        { 
            head = temp.next;   // Change head 
            return; 
        } 
        for (int i=0; temp!=null && i<position-1; i++) 
            temp = temp.next; 
  
        if (temp == null || temp.next == null) 
            return; 

        Node next = temp.next.next; 
  
        temp.next = next;  
    } 

    public void printList() 
    { 
        Node tnode = head; 
        while (tnode != null) 
        { 
            System.out.print(tnode.num+" "); 
            tnode = tnode.next; 
        } 
    } 
    public static void main(String[] args) 
    { 

        LinkedList llist = new LinkedList(); 
  
        llist.push(0); 
        llist.push(1); 
        llist.push(1); 
        llist.push(6); 
        llist.push(10); 
        llist.push(-18); 
  
        System.out.println("Created Linked list is: "); 
        llist.printList(); 
  
        llist.deleteNode(4); 
  
        System.out.println("Linked List after Deletion at position 4: "); 
        llist.printList(); 
    } 
}