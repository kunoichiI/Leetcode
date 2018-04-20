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
        if (start == end) return false;
        this.list.add(new int[]{start, end});
        Collections.sort(this.list, (int[] i1, int[] i2) -> i1[0] - i2[0]);
       
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] < list.get(i - 1)[1]) {
                if (list.get(i)[0] == start)
                    list.remove(i);
                else
                    list.remove(i - 1);
                return false;
            }     
        }
        return true;
    }
    /*
     * 非常直白粗暴的解法，把新的interval加到list后，sort list，
     * 然后根据哪个值等于新加的start， remove 并返回false
     */
}
