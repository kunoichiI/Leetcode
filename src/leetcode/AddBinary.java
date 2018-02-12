package leetcode;
//67. Add Binary
//Given two binary strings, return their sum (also a binary string).
//
//For example,
//a = "11"
//b = "1"
//Return "100".

/*  这个题的巧妙解法，在于把两个pointer分别指向a和b的尾部，然后每次取出两个字符进行相加，如果无法取出字符则按
 * 0 处理， 1+ 0 = 1 （sum /2 == 0， sum % 2 == 1，1+1 = 10 （sum /2 == 1， sum % 2 == 0）
 * 对2 取余数值得到进位值， 对2 取商数得到当前位数字。*/
public class AddBinary {
	@SuppressWarnings("unused")
	public static String addBinary(String a, String b) {
		if (a == null && b == null)
			return null;
		else if (b == null)
			return a;
		else if (a == null)
			return b;
		
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;
		while (i >= 0 || j >= 0) {
			int sum = 0;
			if (i >= 0 && a.charAt(i) == '1')
				sum++;
			if (j >= 0 && b.charAt(j) == '1')
				sum++;
			sum += carry;
			carry = sum / 2;
			sb.insert(0, (char)(sum % 2 + '0'));
			i--;
			j--;
		}
		if (carry == 1)
			sb.insert(0, '1');
		return sb.toString();
	}
	public static void main(String[] args) {
		String a1 = null, b1 = null;
		String a2 = "11", b2 = "1";
		String a3 = "11", b3 = null;
		String a4 = null, b4 = "11";
		String a5 = "10101011", b5 = "10101110";
		String a6 = "1", b6 = "1";
		
		System.out.println(addBinary(a1, b1)); // => null
		System.out.println(addBinary(a2, b2)); // => "100"
		System.out.println(addBinary(a3, b3)); // => "11"
		System.out.println(addBinary(a4, b4)); // => "11"
		System.out.println(addBinary(a5, b5)); // => "101011001"
		System.out.println(addBinary(a6, b6)); // => "10"
	}

}
