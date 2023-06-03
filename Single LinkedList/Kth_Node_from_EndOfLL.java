public class Kth_Node_from_EndOfLL {
    Node head = null;

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

    /*
     Naive method : - 
      1) Calculate length of LL
      2) print (lengh-k+1) node from the beginning of LL

      TC - O(m)  ,where m is size of LL
      SC - O(1)
    */

    public void kthNode_FromLast(int k){
        // Here we are considering 1 th based index
        int len =0;
        Node curr = head;

        while(curr!=null){
            len++;
            curr = curr.next;
        }

        if( len < k){
            System.out.println("Length of LL is smaller than kth index.");
            return ;
        }

        curr = head;
        for(int i=1; i< (len- k+1 ) ;i++){ 
            curr = curr.next;
        }
        System.out.println("Kth Node from Last of LL is : "+curr.data);
        return;
    } 

    /* 
     Using Two pointer method

     Approach ;
     1) Intilize two pointer 'prev' and 'curr' and points to head of LL.
     2) Move the fast pointer to the nth node from the beginning of the list.
     3) Move both the 'prev' and 'curr' pointers simultaneously until the 'curr' pointer reaches the end of the list.            
     4) The 'prev' pointer will be pointing to the nth node from the end of the list.
     
     */

     public void twoPinterMethod(int k){

        // make two pointers
        Node prev = head;
        Node curr = head;

        // move curr to the kth node from start

       for(int i=0;i<k ;i++){
            if(curr==null){
                System.out.println("The LL doesn't have K node");
            }
            curr= curr.next;
       }

        while(curr != null){
            curr  = curr.next;
            prev= prev.next;
        }
        System.out.println("Kth node from End of LL is: "+prev.data);
     }
    


     public static void main(String[] args) {
        
        Kth_Node_from_EndOfLL list = new Kth_Node_from_EndOfLL();

         
        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);
        list.push(50);
        list.kthNode_FromLast(5);
        list.twoPinterMethod(4);
   
     }
}



/*    

Given a Linked List and a number N, write a function that returns the value at the Nth node from the end of the Linked List.



Examples:Input: 1 -> 2 -> 3 -> 4, N = 3
Output: 2 

Naive Approach: Follow the given steps to solve the problem using this approach: 

Calculate the length of the Linked List. Let the length be len. 
Print the (len – n + 1)th node from the beginning of the Linked List. 

Theory ==> https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/ 

*/