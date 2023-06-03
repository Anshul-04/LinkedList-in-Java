

/**
 * 
 * https://leetcode.com/problems/reverse-linked-list/description/
 * 
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
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = null;

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
}