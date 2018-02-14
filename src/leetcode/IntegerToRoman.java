package leetcode;

//12. Integer to Roman
//Given an integer, convert it to a roman numeral.
//
//Input is guaranteed to be within the range from 1 to 3999.

public class IntegerToRoman {
	public static String intToRoman(int num) {
        if (num <= 0) return "";
        
        String[] dict = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            if (num >= val[i]) {
                int cnt = num / val[i];
                num %= val[i];
                for (int j = 0; j < cnt; j++) {
                    res.append(dict[i]);
                }
            }
        }
        return res.toString();
    }
	
	public static void main(String[] args) {
		int num1 = 3999;
		int num2 = 1000;
		int num3 = 456;
		int num4 = 432;
		
		System.out.println("3999 is: " + intToRoman(num1)); // => "MMMCMXCIX"
		System.out.println("1000 is: " + intToRoman(num2)); // => "M"
		System.out.println("456 is: " + intToRoman(num3)); // => "CDLVI"
		System.out.println("432 is: " + intToRoman(num4)); // => "CDXXXII"
	}
}
