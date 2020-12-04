/* 

155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

Methods pop, top and getMin operations will always be called on non-empty stacks.

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 
 */
 

/****************************************************

Solution 1

****************************************************/

class MinStack {
    
    private Node head;

    /** initialize your data structure here. */
    public MinStack() {
        this.head = null;
    }
    
    public void push(int x) {
        if(head == null){
            head = new Node(x, x);
        }else{
            Node newHead = new Node(x, Math.min(head.min, x), head);
            head = newHead;
        }
    }
    
    public void pop() {
        head = head.next;
     }
    
    public int top() {
        return head.value;
    }
    
    public int getMin() {
        return head.min;
    }
    
    private class Node{
        private int value;
        private Node next;
        private int min;
        
        public Node(int value, int min){
            this(value, min, null);
        }
        
        public Node(int value, int min, Node next){
            this.value = value;
            this.next = next;
            this.min = min;
        }
    }
}



