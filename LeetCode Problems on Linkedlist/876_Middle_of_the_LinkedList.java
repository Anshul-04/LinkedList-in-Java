// https://leetcode.com/problems/middle-of-the-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
      ListNode prev = head; 
      ListNode fast = head;

      while(fast!=null && fast.next!=null){
          prev = prev.next;  // moving one node at a time
          fast = fast.next.next ;  // moving two node at a time
      }
      return prev;
    }
}