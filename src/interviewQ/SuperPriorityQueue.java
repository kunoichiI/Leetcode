package interviewQ;
import java.util.*;
/**
* Implement a super queue from set of priority queues
* 
*   0 2 1 q1
*   4 3 5 q2
*   8 9 7 q3
*   peek() - should return 0;
*   poll() - should remove 0 from q1;
*   
*   Note : Don't add all queues to single priority queue as items can be infinite
*/

public class SuperPriorityQueue {
	Set<PriorityQueue<Integer>> queues;
	int min = Integer.MAX_VALUE;
	public SuperPriorityQueue(Set<PriorityQueue<Integer>> queues) {
		this.queues = queues;
	}
	
	public Integer peek() {
		Iterator<PriorityQueue<Integer>> it = queues.iterator();
		while (it.hasNext()) {
			PriorityQueue<Integer> q = it.next();
			if (!q.isEmpty()) {
				//System.out.println("current queue is: " + q);
				
				Integer top = q.peek();
				//System.out.println("top is: " + top);
				if (top < min)
					min = top;	
			}	
		}
		//System.out.println("return value of min: " + min);
		return min;
	}
	
	public Integer poll() {
		Integer val = peek();
		for (PriorityQueue<Integer> pq: queues) {
			if (pq.peek() == val){
				pq.poll();
				min = Integer.MAX_VALUE;
			}
				
		}
		return val;
	}
	public static void main(String[] args) {
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		pq1.add(0);
		pq1.add(1);
		pq1.add(2);
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		pq2.add(4);
		pq2.add(3);
		pq2.add(5);
		
		PriorityQueue<Integer> pq3 = new PriorityQueue<>();
		pq3.add(8);
		pq3.add(9);
		pq3.add(7);
		Set<PriorityQueue<Integer>> set = new HashSet<>();
		set.addAll(Arrays.asList(pq1, pq2, pq3));
		SuperPriorityQueue spq = new SuperPriorityQueue(set);
		System.out.println(spq.peek()); // 0
		System.out.println(spq.poll()); // 0
		System.out.println(spq.peek()); // 1
		System.out.println(spq.poll()); // 1
		System.out.println(spq.peek()); // 2
		System.out.println(spq.poll()); // 2
		System.out.println(spq.peek()); // 3
		System.out.println(spq.poll()); // 3
		System.out.println(spq.peek()); // 4
		System.out.println(spq.poll()); // 4
		System.out.println(spq.peek()); // 5
		System.out.println(spq.poll()); // 5
		System.out.println(spq.peek()); // 7
		System.out.println(spq.poll()); // 7
		System.out.println(spq.peek()); // 8
		System.out.println(spq.poll()); // 8
		System.out.println(spq.peek()); // 9
		System.out.println(spq.poll()); // 9
		System.out.println(spq.peek()); // Integer.MAX_VALUE
		System.out.println(spq.poll()); // Integer.MAX_VALUE
	}

}
