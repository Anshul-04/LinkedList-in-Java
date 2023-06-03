public class ReverseALinkedList {
    static Node head = null;

    // 1) Iterative Method for Reversing LL

    public Node reverseIterative(Node head){

        Node prevNode = null;
        Node currNode = head;
        Node nextNode = null;

        while(currNode !=null){
            // points the currNode to prevNode but before doing that move nextNode to next of currNode.
            // and then reverse the link of cur to prev by pointing the currNode to prevNode and move prevNode

            nextNode = currNode.next; // moving the nextNode 

            currNode.next = prevNode ;  // changig the link of currNode

            // now moving prev and curr node

            prevNode = currNode;

            currNode = nextNode;

        }

        // after the whole list is reversed our new head is prevNode ,so return it. 
        head = prevNode;
        return head;
    }

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

    void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        return;
    }
    void print(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        return;
    }
    public static void main(String[] args) {
        
        ReverseALinkedList list = new ReverseALinkedList();
        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);
        list.push(50);
        System.out.print("Original List : ");
        list.print();    
        System.out.print("\nReverse List : ");
        Node reverseHead =  list.reverseIterative(head);
        list.print(reverseHead);
    }
}
