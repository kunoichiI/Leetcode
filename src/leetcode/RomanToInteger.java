package leetcode;

import java.util.HashMap;

//13. Roman to Integer  
//Difficulty: Easy
//Given a roman numeral, convert it to an integer.
//
//Input is guaranteed to be within the range from 1 to 3999.

public class RomanToInteger {
	public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
	    m.put('V', 5);
	    m.put('X', 10);
	    m.put('L', 50);
	    m.put('C', 100);
	    m.put('D', 500);
	    m.put('M', 1000);
	    
	    int length = s.length();
	    int result = m.get(s.charAt(length -1));
	    for (int i = length - 2; i >= 0; i--) {
	        if (m.get(s.charAt(i+1)) <= m.get(s.charAt(i))) {
	            result += m.get(s.charAt(i));
	        }else {
	            result -= m.get(s.charAt(i));
	        }
	    }
	    return result;
    }
	
	/*
	 * 解题思路：对这个罗马字符串，由后往前进行遍历，最后一个值直接由map得出，然后对index从length - 2开始
	 * 的起始字符，如果前面的比后面的小，则加到结果里，如果前面的比后面的大，比如“IV”， 则从结果里减去这个数值（这个例子
	 * 里是I） 所以 5 - 1 = 4； 又或者“XC”， X对应是10， C对应是100， 所以用100 - 10 = 90；
	 */
}
