package interviewQ;

import java.util.HashSet;
import java.util.Set;

// yelp interview question:
// Output all possible combination of a2c (变换大小写)
// "a2c" -> ["a2c", "A2c", "a2C", "A2C"]
public class AllCombs { // o(n) time, o(n) space
	public static Set<String> allCombs(String s) {
		Set<String> combs = new HashSet<>();
		if (s == null || s.length() == 0)
			return combs;
		combs.add(s);
		
		for (int i = 0; i < s.length(); i++) {
			Set<String> newComb = new HashSet<>();
			for (String str : combs) {
				char c = s.charAt(i);
				if (Character.isLowerCase(c)) {
					newComb.add(str.substring(0, i) + Character.toUpperCase(str.charAt(i)) + str.substring(i + 1));
				}
			}
			combs.addAll(newComb);
		}
		return combs;
	}
	public static void main(String[] args) {
		String s = "a2c";
		//String s2 = "abc234efgcc";
		Set<String> set1 = allCombs(s);
		set1.stream().forEach(System.out::println);
		System.out.println("---------------");
//		Set<String> set2 = allCombs(s2);
//		set2.stream().forEach(System.out::println);
	}

}
