package leetcodeAbove200;

import java.util.*;
// Leetcode 253  Meeting Rooms II
// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
// find the minimum number of conference rooms required.
// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return 2.

// Solution analysis: intervals with overlappings cannot use one meeting room. so sort the array first
// poll non-overlapping from min heap and increase rooms whenever overlapping happens

public class MeetingRoomsII { // (Greedy algorithm + priority queue solution) Time complexity o(nlogn), space complexity o(n)
	public static int minMeetingRooms(Interval[] intervals) { 
		// corner cases first
		if (intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, (Interval i1, Interval i2) -> i1.start - i2.start);
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		minHeap.offer(intervals[0].end);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start >= minHeap.peek())
				minHeap.poll();
			minHeap.offer(intervals[i].end);
		}
		return minHeap.size();
	}
	
	public static void main(String[] args) {
		Interval i1 = new Interval(0, 30);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(15, 20);
		Interval[] intervals = new Interval[3];
		intervals[0] = i1;
		intervals[1] = i2;
		intervals[2] = i3;
		
		System.out.println("Min rooms for this case is: " + minMeetingRooms(intervals)); // => 2
	}
}
