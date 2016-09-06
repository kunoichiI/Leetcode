package leetcode;

//43. Multiply Strings 
//Given two numbers represented as strings, return multiplication of the numbers as a string.
//
//Note:
//The numbers can be arbitrarily large and are non-negative.
//Converting the input string to integer is NOT allowed.
//You should NOT use internal library such as BigInteger.

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
        int num1Len = num1.length();
        int num2Len = num2.length();
        int[] result = new int[num1Len + num2Len];
        
        for (int i = num1Len-1; i >= 0; i--) {
            for (int j = num2Len-1; j >= 0; j--) {
                int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + result[i+j+1];
                result[i+j+1] = multi % 10;
                result[i+j]  += multi / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (sb.length() == 0 && result[i] == 0) { // Skip first 0
                continue;
            }
            sb.append(String.valueOf(result[i]));
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
	
	public static void main(String[] args) {
		MultiplyStrings ms = new MultiplyStrings();
		String num1 = "0", num2 = "456";
		System.out.print(ms.multiply(num1, num2));

	}

}
