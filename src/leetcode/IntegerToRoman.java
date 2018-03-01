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
	
	/*
	 * 这道题的关键是知晓罗马数字和十进制数字的转换规则，然后使用两个array分别存index对应的mappping，数值从大到小排列
	 * 对应其罗马数字字符串
	 * 对于一个int数值，从左往右找到第一个小于当前value的数，然后用数值除以这个array数，得到罗马数字个数
	 * 然后int数值对这个array数取余数并赋值给自身，（相当于减小自己）
	 * 然后继续在array后面寻找第一个小于当前的数。重复此动作直到num变为0.
	 */
}
