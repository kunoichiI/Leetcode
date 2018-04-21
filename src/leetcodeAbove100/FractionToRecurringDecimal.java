package leetcodeAbove100;

import java.util.HashMap;

/*
 * 166. Fraction to Recurring Decimal
 * Given two integers representing the numerator and denominator of a fraction, 
 * return the fraction in string format.

	If the fractional part is repeating, 
	enclose the repeating part in parentheses.

	For example,
	
	Given numerator = 1, denominator = 2, return "0.5".
	Given numerator = 2, denominator = 1, return "2".
	Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 */
public class FractionToRecurringDecimal {
	/* time: O(N), N is the length of quotient(repeat or not)
	 * space: O(N) same N*/
	public static String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		StringBuilder sb = new StringBuilder();
		// "+" or "-"
		sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);
		
		// integral part
		sb.append(num / den);
		num %= den;
		if (num == 0) return sb.toString();
		
		// fractional part
		sb.append('.');
		HashMap<Long, Integer> map = new HashMap<>();
		map.put(num, sb.length());
		while (num != 0) {
			num *= 10;
			sb.append(num / den);
			num %= den;
			if (map.containsKey(num)) {
				int index = map.get(num);
				sb.insert(index, "(");
				sb.append(')');
				break;
			}
			else {
				map.put(num, sb.length());
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(1, 2)); // 0.5
		System.out.println(fractionToDecimal(2, 1)); // 2
		System.out.println(fractionToDecimal(2, 3)); // 0.(6)
	}
	
	/*
	 * 这是最快的AC解法， 3ms
	 * 用HashMap存储每一个remainder，当出现重复的时候，在重复的那一位之前
	 * insert （，在最后append ），然后输出整个字符串。
	 * 如果fraction 部分不出现重复， 则反复运算直到分子为0.
	 * 把每一个商加入string
	 */

}
