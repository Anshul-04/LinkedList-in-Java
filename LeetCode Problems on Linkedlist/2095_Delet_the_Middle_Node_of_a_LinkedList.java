// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

class Solution {
    public ListNode deleteMiddle(ListNode head) {

// if LL has one one or no node then return null
        if(head==null || head.next==null){
            return null ;
        }
        
        // Using tortoise and hare method
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevOfSlow = null;

        while(fast!=null && fast.next!=null){
            prevOfSlow = slow;  // move prevOfSlow to slow

            slow = slow.next;  // move slow one node forward

            fast = fast.next.next;  // move fast 2 node forward
        }
        // after the loop slow is the middle node which is to be deleted

        prevOfSlow.next = slow.next;
        return head;

    }
}