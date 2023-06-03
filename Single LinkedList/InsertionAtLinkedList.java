class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        next = null;
    }
}

public class InsertionAtLinkedList{
    Node head = null;

    // insertion at head of LL

    void insertAtHead(int data){
        Node newNode = new Node(data);

        // if LL is null then make newNode the head of LL
        if(head==null){
            head = newNode;
            return;
        }

        // otherwise  points the newNode to head of LL and then make it head of LL
        newNode.next = head ;
        head = newNode;
        return;
    }

    // insertion at the tail of LL

    void insertAtTail(int data){

        Node newNode = new Node(data);

        if(head==null){
            head = newNode;
            return;
        }

        Node curr = head;

        // traversig till the tail of LL
        while(curr.next != null){
            curr = curr.next ;  // moving one node forward
        }
        // when we came out of the loop it means we are at last node of LL
        curr.next = newNode;
        newNode.next = null;
        return;
    }

    // Insertion at specific position
    
    // 1) insert at kth position     TC - O(N) SC- O(1)

    void insertAtKthPosition(int k,int data){
        Node newNode = new Node(data);

        // make two node prev and curr to traverse the list 
        Node prev = null;
        Node curr = head;

        // if k is 1 then insert at head
        if(k==1){
           newNode.next = head;
           head = newNode;  
           return;
        }

        for(int i=1; i<k ; i++){
            prev = curr;
            curr = curr.next;
        }
        // after this loop curr is the kth node 

        prev.next = newNode;
        newNode.next = curr;
        return;
    }

    // 2) insert After given node method    TC - O(1) SC- O(1)

    void insertAfter(Node curr,int data){

        Node newNode = new Node(data);

        // if curr is null then return
        if(curr==null){
            System.out.println("Node cannot be null");
        }

        // 1 --> 2 --> 3 --> curr --> 6 --> 21 --> null

        //   newNode

        // make newNode points to the curr's node next
        newNode.next = curr.next;

       /*   1 --> 2 --> 3 --> curr |--> 6 --> 21 --> null
                                   |
                         newNode --|  */

        curr.next = newNode;
         /*   1 --> 2 --> 3 --> curr-|             |--> 6 --> 21 --> null
                                     |             |
                                      -> newNode --|  
                               */

        return;                       
       

    }


    void print(){
        Node curr = head;

        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
        InsertionAtLinkedList list = new InsertionAtLinkedList();
        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtHead(30);
        list.insertAtHead(40);
        System.out.print("Insertion at Head : ");
        list.print();   // 40 30 20 10 

        list.insertAtTail(3);
        list.insertAtTail(12);

        System.out.print("Insertion at Tail : ");
        list.print();     // 40 30 20 10 3 12
        list.insertAtKthPosition(2, 80);

        System.out.print("Insertion at 2nd Position : ");
        list.print();   // 40 80 30 20 10 3 12

        list.insertAfter(list.head.next.next, 100);
        System.out.print("Insertion at Afetr Node '30' : ");   // 40 80 30 100 20 10 3 12
        list.print();
        
    }
}

/* 
Theory : https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/

*/