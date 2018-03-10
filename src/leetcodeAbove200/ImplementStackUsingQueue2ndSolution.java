package leetcodeAbove200;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue2ndSolution { // push time: o(n), pop: o(1)
	Queue<Integer> q1;
    Queue<Integer> q2;
    int top;
    /** Initialize your data structure here. */
    public ImplementStackUsingQueue2ndSolution() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q2.add(x);
        top = x;
        while(!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int poped = q1.remove();
        if (!q1.isEmpty()) {
            top = q1.peek();
        }
        return poped;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.size() == 0;
    }
    
    /*
     * 解题思路：用两个queue和一个top变量，q1保持着上一个push值永远在front，q2push进新的push值，
     * 如果q1不为空，把q1 的数全部挪去q2，对调q1和q2，这样新push的值仍旧在q1的最前面。实现了stack LIFO
     * pop的时候直接remove q1最前面的数即可，并更新top为q1.peek（）
     */
}
