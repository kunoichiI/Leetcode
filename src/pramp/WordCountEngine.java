package pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Implement a document scanning function wordCountEngine, which receives a string document and returns a list of all unique words in it and their number of occurrences, 
//sorted by the number of occurrences in a descending order. If two or more words have the same count, they should be sorted alphabetically (in an ascending order). Assume that all letters are in english alphabet. You function should be case-insensitive, 
//so for instance, the words “Perfect” and “perfect” should be considered the same word.
//The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.
//Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial space complexity.
//Examples:
//input:  document = "Practice makes perfect. you'll only
//                    get Perfect by practice. just practice!"
//output: [ ["practice", "3"], ["perfect", "2"],
//          ["by", "1"], ["get", "1"], ["just", "1"],
//          ["makes", "1"], ["only", "1"], ["youll", "1"]  ]
//Important: please convert the occurrence integers in the output list to strings (e.g. "3" instead of 3). We ask this because in compiled languages such as C#, Java, C++, C etc., it’s not straightforward to create mixed-type arrays
// (as it is, for instance, in scripted languages like JavaScript, Python, Ruby etc.). The expected output will simply be an array of string arrays.
//Constraints:
//
//[time limit] 5000ms
//[input] string document
//[output] array.array.string
class Pair implements Comparable<Pair> {
	String word;
	int count;
	public Pair(String w, int c) {
		this.word = w;
		this.count = c;
	}
	
	public int compareTo(Pair p) {
		return p.count - this.count;
	}
}

public class WordCountEngine { // 1/13/2018  being asked in interview
	public static List<Pair> wordCount(String document) {
		if (document == null || document.length() == 0) {
			return null;
		}
		
		Map<String, Integer> map = new HashMap<>();
		String[] allWords = document.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		
		for (String s: allWords) {
			if (!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				map.put(s, map.get(s) + 1);
			}
		}
		
		List<Pair> list = new ArrayList<>();
		for (String key: map.keySet()) {
			list.add(new Pair(key, map.get(key)));
		}
		
		Collections.sort(list); // sort the arraylist
		return list;
	}
	public static void main(String[] args) {
		String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
		List<Pair> l = wordCount(document);
		
		for (Pair p: l) {
			System.out.println("The word is: " + p.word + " and the occurence: " + p.count);
		}
	}

}
