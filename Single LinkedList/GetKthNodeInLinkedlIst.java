class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        next = null;
    }
}

/*  Write a GetNth() function that takes a 
    linked list and an integer index and returns the data value stored in the node at that index position. 
*/


public class GetKthNodeInLinkedlIst {
    static Node head = null;

    // insert node at end
    void push(int data){

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

    // # 1) Get kth Node in the LL from front
    // TC - O(n) SC - O(1)


    void Kth_Node_From_Front(int k){

        int lengthOfLL = length(head);
        if(k > lengthOfLL){
           System.out.println("Length of LL is Shorter than Kth index");
          return;
        }

        Node curr = head;
        int count =0;

        while(curr!=null){
            if(count == k){
                System.out.println("Kth Node from the front is : "+ curr.data);
                return;
            }

            count++;
            curr = curr.next;
        }      

    }

    // # 2) Method 2 Recursion Method
    // TC - O(n) SC - O(n)

    int Kth_recursion(Node head,int k){

       int count=0;

       if(head == null){
        return -1;
       }
       // if count equal too n return node.data
       if(count == k){
        return head.data;
       }
     // recursively decrease n and increase
        // head to next pointer
       return Kth_recursion(head.next, k-1);

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

    public static void main(String[] args) {
        GetKthNodeInLinkedlIst list = new GetKthNodeInLinkedlIst();

        
        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);
        list.push(50);
        list.Kth_Node_From_Front(3);
        int index = list.Kth_recursion(head, 3);
        System.out.println("Kth node using Recursion : "+index);
        
    }
}
