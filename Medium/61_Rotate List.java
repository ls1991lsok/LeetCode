/* 

61. Rotate List

Given the head of a linked list, rotate the list to the right by k places.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 10^9

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

/****************************************************

Solution 1

****************************************************/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        
        ListNode dummy = new ListNode(0, head);
        ListNode last_node = dummy, rotateAfter = dummy;
        int len;
        
        for(len = 0; last_node.next != null; len++) last_node = last_node.next;
        for(int i = len - k % len; i > 0; i--) rotateAfter = rotateAfter.next;
        
        last_node.next = dummy.next;
        dummy.next = rotateAfter.next;
        rotateAfter.next = null;
        
        return dummy.next;
    }
}