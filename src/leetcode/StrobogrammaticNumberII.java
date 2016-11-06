package leetcode;

import java.util.*;
//LC.247 Strobogrammatic Number II
//A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
//Find all strobogrammatic numbers that are of length = n.
//
//For example, Given n = 2, return ["11","69","88","96"].

public class StrobogrammaticNumberII {
	
	char[] table = {'0', '1', '6', '8', '9'};
	static List<String> res;
	
	public List<String> strobogrammaticNum(int n) {
		res = new ArrayList<String>();
		build(n, "");
		return res;
	}
	
	public void build(int n, String s) {
		if (n == s.length()) {
			res.add(s);
			return;
		} 
		boolean last = n - s.length() == 1;
		for (int i = 0; i < table.length; i++) {
			char c = table[i];
			if ((n != 1 && s.length() == 0 && c == '0') || (last &&(c == '6' || c == '9'))) {
				continue;
			}
			
			StringBuilder sb = new StringBuilder(s);
			append(last, c, sb);
			build(n, sb.toString());
		}
	}
	
	public void append(boolean last, char c, StringBuilder sb) {
		if (c == '6') {
			sb.insert(sb.length()/2, "69");
		} else if (c == '9') {
			sb.insert(sb.length()/2, "96");
		} else {
			sb.insert(sb.length()/2, last ? c : ""+c+c);
		}
	}
	
	public static void main(String[] args) {
		StrobogrammaticNumberII sn = new StrobogrammaticNumberII();
		List<String> res = sn.strobogrammaticNum(3);
		System.out.println(res);
		//System.out.println("" + "OK");
	}

}
