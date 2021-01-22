/* 

24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

Example 1:

Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:

Input: head = []
Output: []

Example 3:

Input: head = [1]
Output: [1]

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
 
Follow up: Can you solve the problem without modifying the values in the list's nodes? (i.e., Only nodes themselves may be changed.)

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

Solution 1 --- Iterative

****************************************************/

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy, first = head;
        while(first != null && first.next != null){
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = first;
            first = first.next;
        }
        
        return dummy.next;
    }
}

/****************************************************

Solution 2 --- Recursive

****************************************************/

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        
        return newHead;
    }
}

