package leetcode;
// FB interview Quesiton (Combination Sum) 
//给一个正数n，打印出所有相加的组合
//例如10可以打印出
//1+1+1+...1
//1+2+1+...1
//..
//9+1
//10

import java.util.ArrayList;
import java.util.List;

public class PrintAllSums {
	public static List<List<Integer>> combination(int n) {
	    List<List<Integer>> res = new ArrayList<>();
	    combination(res, new ArrayList<>(), n, 1);
	    return res;
	}
	private static void combination(List<List<Integer>> res, List<Integer> cur, int n, int start) {
	    if (n == 0) {
	        res.add(new ArrayList<>(cur));
	    } else {
	        for (int i = start; i <= n; ++i) {
	            cur.add(i);
	            combination(res, cur, n - i, i);
	            cur.remove(cur.size() - 1);
	        }
	    }
	}
	
	public static void main(String[] args) {
	    System.out.println(combination(10));
	}
}
