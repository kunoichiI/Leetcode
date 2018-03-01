package leetcodeAbove200;
import java.util.*;
//Design an algorithm to encode a list of strings to a string. 
//The encoded string is then sent over the network and is decoded back to the original list of strings.
//
//Machine 1 (sender) has the function:
//
//string encode(vector<string> strs) {
//  // ... your code
//  return encoded_string;
//}
//
//Machine 2 (receiver) has the function:
//
//vector<string> decode(string s) {
//  //... your code
//  return strs;
//}
//So Machine 1 does:
//
//string encoded_string = encode(strs);
//and Machine 2 does:
//
//vector<string> strs2 = decode(encoded_string);
//strs2 in Machine 2 should be the same as strs in Machine 1.
//
//Implement the encode and decode methods.
//
//Note:
//
//The string may contain any possible characters out of 256 valid ascii characters. 
//Your algorithm should be generalized enough to work on any possible characters.
//Do not use class member/global/static variables to store states. 
//Your encode and decode algorithms should be stateless.
//Do not rely on any library method such as eval or serialize methods. 
//You should implement your own encode/decode algorithm.
public class EncodeAndDecodeStrings {
	public static String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			 // encode with stringlength + "#" + str
			if (str == null) sb.append("0#NULL");
			else if (str.length() == 0) sb.append("0#SPAC");
			else {
				int len = str.length();
				sb.append(len).append('#').append(str);
			}	
		}
		return sb.toString();
	}
	
	public static List<String> decode(String encoded_str) {
		List<String> strs = new ArrayList<>();
		if (encoded_str == null || encoded_str.length() == 0) return strs;
		
		int start = 0;
		int end = 0;
		
		while (end < encoded_str.length()) {
			if (encoded_str.charAt(end) == '#') {
				// find the length
				System.out.println("end is " + end);
				int len = Integer.valueOf(encoded_str.substring(start, end));
				// handle null & empty cases here
				if (len == 0) {
					String str = encoded_str.substring(end + 1, end + 4 + 1);
					if (str.equals("NULL")) {
						strs.add(null);
						
					}
					else strs.add("");
					
					start = end + 4 + 1;
					end = start;
				}
				else {
					strs.add(encoded_str.substring(end + 1, end + len + 1));
					start = end + len + 1;
					end = start;
				}
			}
			end++;
		}
		return strs;
	}
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("hello");
		list.add("world!");
		list.add("aloha.");
		
		System.out.println(encode(list)); // "5#hello6#world!6#aloha."
		System.out.println(decode(encode(list))); // ["hello", "world!", "aloha."]
		System.out.println("---------------");
		// followup: add null & empty value into original string list
		List<String> strs = new ArrayList<>();
		strs.add(null);
		strs.add("");
		strs.add("Mingyuan!");
		
		System.out.println(encode(strs)); // "0#NULL1#SPACE9#Mingyuan!"
		System.out.println(decode(encode(strs))); // [null, "", "Mingyuan"]
	}

	/* 
	 *  思路：在encode string时，把每个string长度记录好，然后放入#， 后面跟上这个string
	 *  比如“abc” 变为 “3#abc”， 如果是“456tye”，则encoded变为“6#456tye”
	 *  解码decode时，先数#个数，如果#前面是数字，则表明#后面的字符串长度。
	 */
}
