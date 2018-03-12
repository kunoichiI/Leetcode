package leetcodeAbove300;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 346 Moving Average from Data Stream
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

	For example,
	MovingAverage m = new MovingAverage(3);
	m.next(1) = 1
	m.next(10) = (1 + 10) / 2
	m.next(3) = (1 + 10 + 3) / 3
	m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {
	private Queue<Integer> queue;
	private int size;
	private int sum;
	public MovingAverageFromDataStream(int size) {
		sum = 0;
		this.size = size;
		queue = new LinkedList<Integer>();
	}
	
	public int next(int val) {
		if (queue.size() >= size) {
			int poped = queue.poll();
			sum -= poped;
		}
		queue.add(val);
		sum += val;
		return sum / queue.size();
	}
	public static void main(String[] args) {
		MovingAverageFromDataStream m = new MovingAverageFromDataStream(3);
		System.out.println(m.next(1)); // 1
		System.out.println(m.next(10)); // 5
		System.out.println(m.next(3)); // 4
		System.out.println(m.next(5)); // 6
	}

}
