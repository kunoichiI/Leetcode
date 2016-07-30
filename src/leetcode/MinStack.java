package leetcode;

import java.util.Stack;

//155. Min Stack  QuestionEditorial Solution  My Submissions
//Total Accepted: 82450
//Total Submissions: 348699
//Difficulty: Easy
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//top() -- Get the top element.
//getMin() -- Retrieve the minimum element in the stack.
//Example:
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> Returns -3.
//minStack.pop();
//minStack.top();      --> Returns 0.
//minStack.getMin();   --> Returns -2.

public class MinStack {  // Two stacks, one to store values, the other to store minValue when a value being pushed in to the first stack
	 private Stack<Integer> stack;
	    private Stack<Integer> minStack;
	    /** initialize your data structure here. */
	    public MinStack() {
	        stack = new Stack<Integer>();
	        minStack = new Stack<Integer>();
	    }
	    
	    public void push(int x) {
	        stack.push(x);
	        if (minStack.isEmpty()) {
	            minStack.push(x);
	        }else {
	            minStack.push(Math.min(minStack.peek(), x));
	        }
	    }
	    
	    public void pop() {
	        minStack.pop();
	        stack.pop();
	    }
	    
	    public int top() {
	        return stack.peek();
	    }
	    
	    public int getMin() {
	        return minStack.peek();
	    }
}


	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */

