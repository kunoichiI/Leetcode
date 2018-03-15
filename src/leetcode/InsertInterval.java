package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/*
 * 57. Insert Interval
 * 	Given a set of non-overlapping intervals, 
 * 	insert a new interval into the intervals (merge if necessary).

	You may assume that the intervals were initially sorted according to their start times.
	
	Example 1:
	Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
	
	Example 2:
	Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
	
	This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        
        PriorityQueue<Interval> queue = new PriorityQueue<>((i1, i2) -> i1.start - i2.start);
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (!hasOverlapping(newInterval, cur))
                queue.offer(cur);
            else { // merge and assign the merged value to newInterval
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.max(cur.end, newInterval.end);
            }
        }
        queue.add(newInterval);
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }
    
    public static boolean hasOverlapping(Interval i1, Interval i2) {
        if (i1.start - i2.start > 0) {
            Interval temp = i1;
            i1 = i2;
            i2 = temp;
            return hasOverlapping(i1, i2);
        }
        return i2.start <= i1.end;
    }
	public static void main(String[] args) {
		List<Interval> list1 = new ArrayList<>();
		list1.add(new Interval(1, 3));
		list1.add(new Interval(6, 9));
		List<Interval> res1 = insert(list1, new Interval(2, 5)); // [[1,5], [6, 9]]
		res1.forEach(it -> System.out.format("interval %s start is %d and end is %d\n", it, it.start, it.end));
		System.out.println();
		List<Interval> list2 = new ArrayList<>();
		list2.add(new Interval(1, 2));
		list2.add(new Interval(3, 5));
		list2.add(new Interval(6, 7));
		list2.add(new Interval(8, 10));
		list2.add(new Interval(12, 16));
		List<Interval> res2 = insert(list2, new Interval(4, 9)); // [[1,2], [3, 10], [12, 16]
		res2.forEach(it -> System.out.format("interval %s start is %d and end is %d\n", it, it.start, it.end));
	}
	
	/*
	 * 解题思路，把非重合的interval直接加入priorityqueue，把重合的纷纷merge入newInterval，循环后
	 * 把newInterval加入队列，再依次出队，用res装起来
	 */

}
class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}