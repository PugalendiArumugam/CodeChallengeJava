package LeetCode.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.



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
 */
public class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minValuesStack = new ArrayDeque<>();

    public MinStack() {
        minValuesStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minValuesStack.push(Math.min(val, minValuesStack.peek()));
    }

    public void pop() {
        stack.pop();
        minValuesStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValuesStack.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());
    }
}
