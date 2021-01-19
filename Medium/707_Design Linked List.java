/* 

707. Design Linked List

Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 

Example 1:

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3

Constraints:

0 <= index, val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail,  addAtIndex and deleteAtIndex.

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 
 */

/****************************************************

Solution 1

****************************************************/

class MyLinkedList {
    
    private Node head;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        else{
            Node cur = head;
            for(int i = 0; i < index ; i++) cur = cur.next;
            return cur.val;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newHead = new Node(val, head);
        head = newHead;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(size == 0 || head == null) addAtHead(val);
        else{
            Node cur = head;
            while(cur.next != null) cur = cur.next;
            cur.next = new Node(val);
            size++;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) return;
        else if(index == 0) addAtHead(val);
        else if(index == size) addAtTail(val);
        else{
            Node cur = head;
            for(int i = 0; i < index - 1; i++) cur = cur.next;
            Node next = cur.next;
            cur.next = new Node(val, next);
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        else if(index == 0){
            head = head.next;
            size--;
        }else{
            Node cur = head;
            for(int i = 0; i < index - 1; i++) cur = cur.next;
            cur.next = cur.next.next;
            size--;
        }
    }
    
    private class Node{
        private Node next;
        private int val;
        
        public Node(int val){
            this(val, null);
        }
        
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
}