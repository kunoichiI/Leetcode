package pramp;

import java.util.HashMap;
//Smallest Substring of All Characters (pramp 1/12/2018 Friday Mock interview question)
//Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring 
//that finds the smallest substring of str containing all the characters in arr. 
//Return "" (empty string) if such a substring doesn’t exist.
//Come up with an asymptotically optimal solution and analyze the time and space complexities.
//Example:
//input:  arr = ['x','y','z'], str = "xyyzyzyx"
//output: "zyx"

public class ShortestUniqueSubstring {
	 public static String getShortestUniqueSubstring(char[] arr, String str) {
		    // your code goes here
		    int counter = 0; 
		    String res = "";
		    int headIndex = 0;
		    HashMap<Character, Integer> map = new HashMap<>();
		    
		    // initialize map
		    for (int i = 0; i < arr.length; i++) {
		      map.put(arr[i], 0);
		    }
//		    for(Character key: map.keySet()) {
//	    	  		System.out.println("key: " + key + ", value: " + map.get(key));
//		    }
		    
		    // scan str
		    for (int tailIndex = 0; tailIndex < str.length(); tailIndex++) {
		      char tailChar = str.charAt(tailIndex);
		      System.out.println("tailIndex: " + tailIndex + " tailChar: " + tailChar);
		      
		      // skip all the characters not in arr
		      if (!map.containsKey(tailChar)) continue;
		      
		      int tailCount = map.get(tailChar);
		      System.out.println("tailCount: " + tailCount);
		      if (tailCount == 0)
		          counter++;
		      System.out.println("counter: " + counter);
		      map.put(tailChar, tailCount + 1);
		      
		      
		      // push head forward
		      while (counter == arr.length) {
		    	  	System.out.println("Inside while loop");
		        int tempLength = tailIndex - headIndex + 1;
		        if (tempLength == arr.length) {
		            return str.substring(headIndex, tailIndex + 1);
		        }
		        		
		        if (res == "" || tempLength < res.length()) {
		          // return a substring of str from headINdex to tailIndex - inclusive
		          res = str.substring(headIndex, tailIndex + 1);
		        }
		        
		        char headChar = str.charAt(headIndex);
		        
		        if (map.containsKey(headChar)) {
		          int headCount = map.get(headChar) - 1;
		          if (headCount == 0) 
		              counter--;
		          map.put(headChar, headCount);
		        }
		        System.out.println("headIndex is  " + headIndex);
		        headIndex++;
		      }
		      
		    }
		    return res;
		  }
	 
	public static void main(String[] args) {
		String str1 = "A";
		char[] arr1 =  {'A'};
		
		String str2 = "xyyzyzyx";
		char[] arr2 = { 'x','y','z' };
		System.out.println("------------------");
		System.out.println(getShortestUniqueSubstring(arr1, str1));
		System.out.println("------------------");
		System.out.println(getShortestUniqueSubstring(arr2, str2));
		System.out.println("------------------");
	}

}
