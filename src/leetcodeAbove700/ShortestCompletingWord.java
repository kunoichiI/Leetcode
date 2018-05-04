package leetcodeAbove700;

import java.util.Arrays;

/*
 * 748. Shortest Completing Word
 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. 
 * Such a word is said to complete the given string licensePlate
	
	Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
	
	It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
	
	The license plate might have the same letter occurring multiple times. For example, 
	given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.
	
	Example 1:
	Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
	Output: "steps"
	Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
	Note that the answer is not "step", because the letter "s" must occur in the word twice.
	Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
	Example 2:
	Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
	Output: "pest"
	Explanation: There are 3 smallest length words that contains the letters "s".
	We return the one that occurred first.
	Note:
	licensePlate will be a string with length in range [1, 7].
	licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
	words will have a length in the range [10, 1000].
	Every words[i] will consist of lowercase letters, and have length in range [1, 15].

 */
public class ShortestCompletingWord {
	/* time complexity: O(N), N is number of words , space: O(1) */
	public static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] arr = new int[26]; // mapping to 26 alphabet letters
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        licensePlate = licensePlate.toLowerCase();
        //System.out.println(licensePlate);
        for (char c: licensePlate.toCharArray()) {
            if (!Character.isLetter(c)) continue;
            //System.out.println("c is: " + c);
            arr[c - 'a']++;
        }
        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            if (words[i].length() >= minLen || !containsAll(words[i], arr)) continue;  
	        minLen = len;
	        ans = words[i];
	        System.out.println("minLen is: " + minLen);    
        }
        return ans;   
    }
    
    public static boolean containsAll(String word, int[] arr) {
        int match[] = new int[26];
        for (char c: word.toCharArray()) {
        		match[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
        		if (match[i] < arr[i]) return false;
        }
        return true;
    }
	public static void main(String[] args) {
		System.out.println(shortestCompletingWord("1s3 PSt", new String[] {"step", "steps", "stripe", "stepple"}));
	}

}
