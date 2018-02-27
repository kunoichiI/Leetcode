package leetcodeAbove100;

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

public class MinStack { 
	// O(1) time, O(1) extra space
	private Stack<Integer> stack;
	private int minValue;
	
	public MinStack() {
		stack = new Stack<Integer>();
		minValue = Integer.MAX_VALUE;
	}
	
	public int getMin() {
		return minValue;
	}
	
	public void pop() {
		if (stack.pop() == minValue) minValue = stack.pop();
	}
	
	public void push(int x) {
		if (x <= minValue) {
			stack.push(minValue);
			System.out.println("minValue: " + minValue + " has been pushed into stack");
			minValue = x;
		}
		stack.push(x);
	}
	
	public int top() {
        return stack.peek();
    }
	
    public static void main(String[] args)
    {
        MinStack s = new MinStack();
        s.push(3);
        s.push(5);
        System.out.println(s.getMin()); // 3
        s.push(2);
        s.push(1);
        System.out.println(s.getMin()); // 1
        s.pop();
        System.out.println(s.getMin()); // 2
        s.pop();
        System.out.println(s.top());  // 5
        System.out.println(s.getMin()); // 3
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

