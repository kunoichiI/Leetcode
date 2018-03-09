package leetcodeAbove100;
//168. Excel Sheet Column Title
//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//For example:
//
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
public class ExcelSheetColumnTitle { // o(log26n) time complexity, o(n) space
	private static int BASE = 26;
	 public static String convertToTitle(int n) {
	        if (n == 0) return "";
	        StringBuilder sb = new StringBuilder();
	        
	        while (n > 0) {
	            int mod = n % BASE; // modulo operation is soooo cool! GOtta remember this
	            if (mod == 0) {
	                sb.append('Z');
	                n--;
	            }   
	            else
	                sb.append((char)(65 + mod - 1)); // this is smart!
	            n = n / BASE;
	        }
	        return sb.reverse().toString();
	    }
	public static void main(String[] args) {
		System.out.println("26 is in excel :" + convertToTitle(26)); // "Z"
		System.out.println("59 is in excel :" + convertToTitle(59)); // "BG"
		System.out.println("226 is in excel :" + convertToTitle(226)); // "HR"
	}
	/*
	 * 解题思路：把数字转化成26进制，1 ～ 26 分别对应A～ Z
	 * Excel Column命名规则是 A~Z, AA～ZZ，AAA～ZZZ，对于一个给定的数值，对其取余数得到最后一位
	 * 由于Z代表的26 取余数时为0，所以Z前面得到的n/26 要减去1（特殊情况）
	 * 其余的就是把A（65） 转化为相应的大写字符。 （char）（65 + modulo - 1）
	 */
}
