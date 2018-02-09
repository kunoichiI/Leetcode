package interviewQ;

import java.util.ArrayList;
import java.util.List;

public class AllCombsRecursive { // o(n) time, o(n) space
	public static List<String> allCombsRec(String s, int pos) {
		List<String> combs = new ArrayList<String>();
		if(s==null || s.length()==0) {
			return combs;
		}
		if(pos >= s.length()) {
			combs.add("");
			return combs;
		}
		for(String str: allCombsRec(s, pos + 1)) {
			if(Character.isLowerCase(s.charAt(pos))) {
				combs.add(Character.toUpperCase(s.charAt(pos)) + str);
			}
			combs.add(s.charAt(pos) + str);
		}
		return combs;
	}
	public static void main(String[] args) {
		String s1 = "a2c";
		String s2 = "abc234efgcc";
		List<String> res1 = allCombsRec(s1, 0);
		List<String> res2 = allCombsRec(s2, 0);
		res1.stream().forEach(System.out::println);
		System.out.println("----------------");
		res2.stream().forEach(System.out::println);
	}

}
