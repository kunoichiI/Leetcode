package leetcodeAbove200;

import java.util.*;

// 252 Meeting Rooms
// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
// determine if a person could attend all meetings. For example, Given [[0, 30],[5, 10],[15, 20]], return false.

public class MeetingRooms {
	public static boolean canAttendMeetings(Interval[] intervals) {
		// corner cases first
		if (intervals == null || intervals.length == 0)
			return false;
		// sort intervals according to their start time (Lambda function as the comparator object)
		Arrays.sort(intervals, (Interval i1, Interval i2) -> i1.start - i2.start);
		
		for (int i = 0; i < intervals.length -1; i++) {
			if (intervals[i].end > intervals[i+1].start) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Interval i1 = new Interval(0, 30);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(15, 20);
		Interval[] intervals = new Interval[3];
		intervals[0] = i1;
		intervals[1] = i2;
		intervals[2] = i3;
		System.out.println("Can attend meetings: " + canAttendMeetings(intervals)); // => false
		
		Interval[] intervals1 = null;
		System.out.println("Can attend meetings: " + canAttendMeetings(intervals1)); // => false
		
		Interval i4 = new Interval(40, 56);
		Interval[] intervals2 = new Interval[2];
		intervals2[0] = i1;
		intervals2[1] = i4;
		System.out.println("Can attend meetings: " + canAttendMeetings(intervals2)); // => true
	}
	
}
