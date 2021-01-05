/* 

234. Palindrome Linked List

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false

Example 2:

Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?

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
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        ListNode walker = head;
        ListNode runner = head;
        while(runner != null && runner.next != null){
            walker = walker.next;
            runner = runner.next.next;
        }
        if(runner != null) walker = walker.next;
        walker = reverse(walker);
        runner = head;
        while(walker != null){
            if(walker.val != runner.val) return false;
            walker = walker.next;
            runner = runner.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}