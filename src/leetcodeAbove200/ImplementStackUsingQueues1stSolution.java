package leetcodeAbove200;
// 225. Implement Stack using Queues
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues1stSolution { // push time: o(1), pop: o(n)
	Queue<Integer> q1;
    Queue<Integer> q2;
    int top;
    /** Initialize your data structure here. */
    public ImplementStackUsingQueues1stSolution() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        int res = q1.remove();
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.size() == 0;
    }
    
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    
    /*
     * 解题思路： 用两个queue和一个top变量存最新加入的值。push的时候直接push上q1， 更新top值，
     * pop的时候把q1最新push的值留下，其他push进q2，while loop同时更新top值， 然后pop出这个最新值
     * 最后对调q1和q2，这样q2又变成空的queue，而q1存着pop后剩下的值，实现了LIFO
     */
}
