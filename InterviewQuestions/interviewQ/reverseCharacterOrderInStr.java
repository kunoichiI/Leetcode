package interviewQ;
// Question: Given "____The__quick_brown_fox___"
//          return:"____ehT__kciuq_nowrb_xof___"

public class reverseCharacterOrderInStr {
	public static void reverseString(char[] charArr) {
		int wordStartIdx = -1;
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == ' ') { // ignore spaces
				continue;
			}
			if (wordStartIdx < 0) { // Mark start of word
				wordStartIdx = i;
			}
			if (i + 1 == charArr.length || charArr[i+1] == ' ') { // word ends here, start reversing it
				for (int a = wordStartIdx, b = i; a < b; a++, b--) {
					char swap = charArr[a];
					charArr[a] = charArr[b];
					charArr[b] = swap;
				}
				wordStartIdx = -1; // reset wordStartIdx here after each reverse
			}
		}
	}
		
	public static void main(String[] args) {
		char[] arr1 = "    The quick brown fox  ".toCharArray();
		char[] arr2 = "".toCharArray();
		
		reverseString(arr1);
		reverseString(arr2);
		
		System.out.println("arr1 is:" + new String(arr1));
		System.out.println("arr2 is:" + new String(arr2));
	}

}
