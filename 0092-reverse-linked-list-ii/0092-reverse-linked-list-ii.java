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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode preReverse = dummyHead;
        for(int i=0; i<left-1; i++){
            preReverse=preReverse.next;
        }  
        ListNode SubListHead = preReverse.next;
        ListNode prev = null;
        ListNode curr = SubListHead; 
        for (int i = 0; i <= (right - left); i++) {
            ListNode nextTemp = curr.next; // Save the next node
            curr.next = prev;              // Reverse the current node's pointer
            prev = curr;                   // Move prev forward
            curr = nextTemp;  
        }

        preReverse.next = prev;
        SubListHead.next = curr;
        return dummyHead.next;
    }
}