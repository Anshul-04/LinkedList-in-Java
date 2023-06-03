class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        next = null;
    }
}
public class MiddleOfLL {
    Node head = null;

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

    // Tortoise and hare method
    void printMiddle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is the middle node 
        System.out.println("Middle of LL is :"+ slow.data);
        return;
    }

    public static void main(String[] args) {

        MiddleOfLL list = new MiddleOfLL();

        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);
        list.push(50);
        list.printMiddle();

    }
    
}
