package leetcode;

import java.util.ArrayList;

public class PascalTriangle {

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> res =new ArrayList<ArrayList<Integer>>();
		if (numRows <= 0) {
			return res;
		}
		ArrayList<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		res.add(pre);
		
		for (int i = 2; i <= numRows; i++) {
			ArrayList<Integer> cur = new ArrayList<Integer>();
			cur.add(1);   // edge of pascal triangle on each level
			for (int j = 0; j < pre.size() - 1; j++) {
				cur.add(pre.get(j) + pre.get(j+1));
			}
			cur.add(1);
			res.add(cur);
			pre = cur;
		}
		return res;
	}
	
	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		ArrayList<ArrayList<Integer>> res = pt.generate(5);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).toString());
		}

	}

}
