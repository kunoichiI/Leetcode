package leetcodeAbove700;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCalendarIBruteForce {
	private List<int[]> list;
    public MyCalendarIBruteForce() {
        this.list = new ArrayList<int[]>();
    }
    
    public boolean book(int start, int end) {
        for (int[] pair : this.list) {
            if (Math.max(pair[0], start) < Math.min(pair[1], end)) return false;
        }
        this.list.add(new int[]{start, end});
        return true;
    }
    /*
     * 非常直白粗暴的解法，把新的interval加到list后，
     * 然后比较开始时间的最大值和结束时间的最小值，如果前者小于后者，则一定有overlapping
     * 比如 【3，9）， 【6， 8）， Math.max（3，6）小于Math.min（9， 8）
     */
}
