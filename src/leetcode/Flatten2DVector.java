package leetcode;

import java.util.Iterator;
import java.util.List;

//Implement an iterator to flatten a 2d vector.
//
//For example, Given 2d vector =
//
//[
//  [1,2],
//  [3],
//  [4,5,6]
//] 
//By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

public class Flatten2DVector {
	Iterator<List<Integer>> it;
	Iterator<Integer> cur;
	
	public Flatten2DVector(List<List<Integer>> vector2d) {
		it = vector2d.iterator();
	}
	
	public int next() {
		hasNext();
		return cur.next();
	}
	
	public boolean hasNext() {
		while (cur == null || !cur.hasNext() && it.hasNext()) {
			cur = it.next().iterator();
		}
		return cur != null && cur.hasNext();
	}
}
