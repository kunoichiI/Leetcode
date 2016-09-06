package leetcode;

import java.util.Arrays;
import java.util.Stack;

//84. Largest Rectangle in Histogram  
//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
//find the area of largest rectangle in the histogram
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
public class LargestRectangleHistogram {
	public int largestRectangleArea(int[] heights) {
	       Stack<Integer> stack = new Stack<Integer>();
	       int i = 0;
	        int maxArea = 0;
	         int[] h = new int[heights.length + 1];
	         h = Arrays.copyOf(heights, heights.length + 1);
	         while(i < h.length){
	             if(stack.isEmpty() || h[stack.peek()] <= h[i]){
	                 stack.push(i++);
	             }else {
	                 int t = stack.pop();
	                 maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
	             }
	         }
	         return maxArea;
	    }
}
