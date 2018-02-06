package leetcodeAbove200;
//273. Integer to English Words
//Convert a non-negative integer to its english words representation. 
//Given input is guaranteed to be less than 2^31 - 1.
//
//For example,
//123 -> "One Hundred Twenty Three"
//12345 -> "Twelve Thousand Three Hundred Forty Five"
//1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {
	public static Map<Integer, String> initializeMap() {
		Map<Integer, String> map = new HashMap<>();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three"); //
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Fourty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        return map;
	}
    public static String numToWords(int num) {
    		Map<Integer, String> map = initializeMap();
    		String res = ""; // initialize empty string variable
            int billion = 1000000000;
            int million = 1000000;
            int thousand = 1000;
            int hundred = 100;
            int ten = 10;
            while (num > 0) {
                if (num / billion > 0) {
                    res += map.get(num / billion) + " Billion ";
                    num %= billion;
                }
                else if (num / million > 0) {
                    res += map.get(num / million) + " Million ";
                    num %= million;
                }
                else if (num / thousand > 0) {
                    res += map.get(num / thousand) + " Thousand ";
                    num %= thousand;
                }
                else if (num / hundred > 0) {
                    res += map.get(num / hundred) + " Hundred";
                    num %= hundred;
                }
                else if (num / ten > 0) {
                    if (map.containsKey(num)) {
                        res += " " + map.get(num);
                    }
                    else {
                        int remain = num % 10; //
                        res += " " + map.get(num - remain) + " " + map.get(remain);
                        num = 0;
                    }       
                }
            }
            return res;
    }
	public static void main(String[] args) {
		System.out.println(numToWords(123));
		System.out.println(numToWords(12345));
		System.out.println(numToWords(1234567));
		System.out.println(numToWords(1234567890));
	}

}
