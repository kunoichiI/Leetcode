package leetcode;

import java.util.*;

import leetcodeAbove200.Interval;
//56. Merge Intervals 
//Given a collection of intervals, merge all overlapping intervals.
//
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].
public class MergeIntervals {
	public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        Collections.sort(intervals, (Interval i1, Interval i2) -> i1.start - i2.start);       
  
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curt = intervals.get(i);
            if (curt.start <= prev.end ){
                prev.end = Math.max(prev.end, curt.end);
            }else{
                result.add(prev);
                prev = curt;
            }
        }
        
        result.add(prev);
        return result;
    }
	
	public static void main(String[] args) {
		
	}
}
