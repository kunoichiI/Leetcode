package leetcode;

import java.util.*;
// Leetcode 253  Meeting Rooms II
// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
// find the minimum number of conference rooms required.
// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return 2.

// Solution analysis: intervals with overlappings cannot use one meeting room. so sort the array first
// poll non-overlapping from min heap and increase rooms whenever overlapping happens

public class MeetingRoomsII {
	public int minMeetingRooms(Interval[] intervals) {  
		Arrays.sort(intervals, new IntervalComparator());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		int rooms = 0;
		for (int i = 0; i < intervals.length; i++) {
			if (minHeap.size() == 0) {
				minHeap.add(intervals[0].end);
				rooms++;
				continue;
			}
			if (minHeap.peek() <= intervals[i].start) {
				minHeap.poll();
				minHeap.add(intervals[i].end);
			} else {
				minHeap.add(intervals[i].end);
				rooms++;
			}
		}
		return rooms;
	}
}

class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval a, Interval b) {
		return a.start - b.start;
	}
}
