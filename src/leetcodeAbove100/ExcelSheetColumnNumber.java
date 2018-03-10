package leetcodeAbove100;
//171. Excel Sheet Column Number
//Related to question Excel Sheet Column Title
//
//Given a column title as appear in an Excel sheet, return its corresponding column number.
//
//For example:
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
        if(s == null || s.length() == 0){
            throw new IllegalArgumentException("Input is not valid!");
        }
 
        int result = 0;
        int i = s.length() - 1;
        int t = 0;
        while(i >= 0){
            char curr = s.charAt(i);
            result += (int) Math.pow(26, t) * (curr - 'A' + 1);
            t++;
            i--;
        }
 
        return result;
    }
	public static void main(String[] args) {
		System.out.println(titleToNumber("AA")); //27
		System.out.println(titleToNumber("AZZ")); // 1378
	}

}
