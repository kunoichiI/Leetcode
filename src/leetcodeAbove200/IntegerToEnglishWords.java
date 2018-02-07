package leetcodeAbove200;
//273. Integer to English Words
//Convert a non-negative integer to its english words representation. 
//Given input is guaranteed to be less than 2^31 - 1.
//
//For example,
//123 -> "One Hundred Twenty Three"
//12345 -> "Twelve Thousand Three Hundred Forty Five"
//1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {
	Map<Integer, String> map = new HashMap<>();
	public void initializeMap() {
		map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three"); 
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Fourty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
	}
    public String numToWords(int num) {
    		initializeMap();
    		StringBuilder sb = new StringBuilder();
            int billion = 1000000000;
            int million = 1000000;
            int thousand = 1000;
            if (num == 0)
    				return map.get(0);
            
            if (num >= billion) {
            		int extra = num / billion;
            		sb.append(convert(extra) + " Billion");
            		num %= billion;
            		//System.out.println("after billion loop : " + num);
            }
            
            if (num >= million) {
            		int extra = num / million;
            		sb.append(convert(extra) + " Million");
            		num %= million;
            		//System.out.println("after million loop : " + num);
            }
            
            if (num >= thousand) {
            		int extra = num / thousand;
            		sb.append(convert(extra) + " Thousand");
            		num %= thousand;
            		//System.out.println("after thousand loop : " + num);
            }
            	
            if (num > 0) {
            		sb.append(convert(num));
            }
            
            
            return sb.toString().trim();
    }
    
    private String convert(int num) {
    		StringBuilder sb = new StringBuilder();
    		if (num >= 100) {
    			int extra = num / 100;
    			sb.append(" " + map.get(extra) + " Hundred");
    			num %= 100;
    			//System.out.println("after hundred loop : " + num);
    		}
    		
    		if(num > 0){
                if(num > 0 && num <= 20){
                    sb.append(" " + map.get(num));
                }else{
                    int numTen = num / 10;
                    sb.append(" " + map.get(numTen * 10));
     
                    int numOne = num % 10;
                    if(numOne > 0){
                        sb.append(" " + map.get(numOne));
                    }
                }
            }
    		
		return sb.toString();
    }
	public static void main(String[] args) {
		IntegerToEnglishWords solution = new IntegerToEnglishWords();
		System.out.println(solution.numToWords(30)); // => "Thirty"
		System.out.println(solution.numToWords(100)); // => "One Hundred"
		System.out.println(solution.numToWords(123));
		System.out.println(solution.numToWords(12345));
		System.out.println(solution.numToWords(1234567));
		System.out.println(solution.numToWords(1234567890));
	}

}
