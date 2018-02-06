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

public class MinStack {  // Two stacks, one to store values, the other to store minValue when a value being pushed in to the first stack
	 
	// O(1) time, O(N) extra space
//	private Stack<Integer> stack;
//	    private Stack<Integer> minStack;
//	    /** initialize your data structure here. */
//	    public MinStack() {
//	        stack = new Stack<Integer>();
//	        minStack = new Stack<Integer>();
//	    }
//	    
//	    public void push(int x) {
//	        stack.push(x);
//	        if (minStack.isEmpty()) {
//	            minStack.push(x);
//	        }else {
//	            minStack.push(Math.min(minStack.peek(), x));
//	        }
//	    }
//	    
//	    public void pop() {
//	        minStack.pop();
//	        stack.pop();
//	    }
//	    
//	    public int top() {
//	        return stack.peek();
//	    }
//	    
//	    public int getMin() {
//	        return minStack.peek();
//	    }
	
	// O(1) time, O(1) extra space
	private Stack<Integer> stack;
	private int minValue;
	
	public MinStack() {
		stack = new Stack<Integer>();
	}
	
	public int getMin() {
		if (!stack.isEmpty()) {
			System.out.println("Minimum Element in the " + " stack is: " + minValue);
			return minValue;
		}else {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
	}
	
	public int peek() {
		if (!stack.isEmpty()) {
			int value = stack.peek();
			if (value < minValue) {
				int actValue = 2 * value - minValue;
				System.out.print("Top Most Element is: ");
				return actValue;
			} else {
				System.out.print("Top Most Element is: ");
				return value;
			}	
		}else {
			System.out.println("Stack is empty ");
			return Integer.MIN_VALUE;
		}
	}
	
	public int pop() {
		if (!stack.isEmpty()) {
			int value = stack.pop();
			if (value < minValue) {
				value = 2 * value - minValue;
			}
			System.out.print("Top Most Element Removed: ");
			return value;
		}else {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
	}
	
	public void push(int x) {
		if (stack.isEmpty()) {
			minValue = x;
			System.out.println("Number Inserted: " + x);
			stack.push(x);
		}else {
			if (x < minValue) {
				stack.push(2*x - minValue);
				minValue = x;
			}else {
				stack.push(x);
			}
		}
	}
	
	public void output() {
		while(!stack.isEmpty()) {
			int x = stack.pop();
			System.out.println(x);
		}
	}
	
	    public static void main(String[] args)
	    {
	        MinStack s = new MinStack();
	        s.push(3);
	        s.push(5);
	        s.getMin();
	        s.push(2);
	        s.push(1);
	        s.getMin();
	        s.pop();
	        s.getMin();
	        s.pop();
	        s.peek();
	        
	        s.output();
	        
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

