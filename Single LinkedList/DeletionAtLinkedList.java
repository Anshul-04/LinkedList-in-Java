class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        next = null;
    }
}
public class DeletionAtLinkedList{
    Node head = null;

    // Insert node at end of LL
    void insertAtTail(int data){

        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node curr = head;

        while(curr.next!=null){
            curr = curr.next ;
        }
        curr.next = newNode;
        newNode.next = null;
        return;
    }


    /*

     # 1) DELETION AT HEAD

        Tc - O(n) and Sc - O(1)
    */

    public void deletAtHead(){

        // if there is one node or null prsent in LL then return
        if(head==null || head.next == null){
            return;
        }

        // otherwise make the 2nd node head

        head = head.next;
        return;
    }  


    /* 
    # 2)  DELETION AT TAIL
        Tc - O(n) and Sc - O(1)
    */

    void deletAtTail(){

        if(head ==null || head.next == null){
            return;
        }
        Node prev = null;
        Node curr = head;

        // traverse till the tail of LL
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }

      /*  when we came out of the while loop ,curr is tail node and prev is 2nd last node 
          so we simply unlimk the 2nd last node from last node .So make prev points to null
        */
        prev.next = null;  

        // or prev.next = curr.next 
        return;
    }


    /* 

    # 3) DELET Kth Node of LL

    Tc - O(n) best case = O(1) when there is one node
    and Sc - O(1)
    */

    public void deletKthNode(int k){

        // If the LL is empty or contains only one Node then return;
        if(head==null || head.next ==null){
            return;
        }

        // if the node to be deleted is head 
        if(k==0){
            head = head.next;
            return;
        }

        int lengthOfLL = length(head);

        if( k > lengthOfLL){
             System.out.println("The position is more than the number of Nodes");
             return;
        }

        // make two nodes ,curr represent the position at which node to be deleted and prev is the node before curr
        Node curr = head;
        Node prev = null;

        int i=0;

        while( i<k && curr.next!=null){
            prev = curr;
            curr = curr.next;
            i++;
        }
        /*  So after reaching at the desired position,curr is the node to be deleted
            Simply points the prev 's next  to the curr's next node ,then our curr got
            unlinked from both side and thus deleted
        */

        prev.next = curr.next;
        return;
    }


    /* # 4)  DELET the First Node WHERE DATA == KEY  */

    public void deletGivenKeyNode(int key){

        Node curr = head;
        Node prev = null;

        if(head==null){
            return;
        }

        // If the head node otself contain the key to be deleted 
        if( curr!=null && curr.data == key){
            head = head.next;
            return;
        }

        // Seacrh the key to be deleted ,keep track of prev node as we nedd to change curr node next pointer

        // we keep moving in the LL untill our curr is not wqual to key
        while(curr!=null && curr.data!=key){
            prev = curr;
            curr = curr.next;
        }
        // if after while loop the curr node is null then it means the key is not present in the LL
        if(curr == null){
            return;
        }
        else{
            // curr is the node with given key 

            prev.next = curr.next;
            return;
        }
    }

    /* 
    # 5) DELETE MIDDLE OF LINKEDLIST

    Using fast and slow pointer method or tortoise and hare method

    */

    public void deletMiddle(){

        Node slow = head ;  // it moves one step 
        Node fast = head;    // it moves two steps
        Node prevOfSlow = null;

        while(fast!=null && fast.next != null){
            
            prevOfSlow = slow;

            slow = slow.next;  

            fast = fast.next.next;
        }

        // slow is the middle Node of LL

        prevOfSlow.next = slow.next;
        return;

    }




    // Function to calculate Length of LL
    int length(Node head){
        Node curr = head;

        int count =0;

        if(curr==null){
            return 0;
        }

        while(curr!=null){
            count++;
            curr = curr.next;
        }
        return count;
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

 
        DeletionAtLinkedList list = new DeletionAtLinkedList();

        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtTail(40);
        list.insertAtTail(50);

        // current LL is 10 20 30 40 50

        System.out.println("Delet Node at Head : ");
        list.deletAtHead();   // 20 30 40 50
        list.print(); 

        System.out.println("Delet Node at Tail: ");
        list.deletAtTail();   // 20 30 40 
        list.print(); 


        // here we are considering oth based index
        System.out.println("Delet Node at position 2nd : "); // 20 30 40 
        list.deletKthNode(1);   // 20  40  
        list.print(); 

        list.insertAtTail(60);
        list.insertAtTail(25);
        list.insertAtTail(100);

        // the LL  beome 20 40 60 25 100
        System.out.println("Delet the Node where data is 60 : "); // 20 30 40 
        list.deletGivenKeyNode(60);   // 20 40 25 100 (60 is deleted)
        list.print(); 
        

        System.out.println("Delet the Mioddle Node of LL  : "); // 20 40 25 100 
        list.deletMiddle();    // 20 40 100  =>25 is middle node and got deleted)
        list.print();




    }
}
/*  
https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/ 
*/