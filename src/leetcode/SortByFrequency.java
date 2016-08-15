package leetcode;

import java.util.*;
public class SortByFrequency {

	static void customSort(int[] arr) {
        // Create frequency map using Hashmap 
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (frequencyMap.containsKey(key)) {
                frequencyMap.put(key, frequencyMap.get(key) + 1);
            }else {
                frequencyMap.put(key, 1);
            }
        }
        
        // List containing elements of map's entry set.
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        // Sort the list
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>(){
        	@Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

		
        });

        int index = 0;
        // Arrange array elements in sorted list of entry set of frequency map
        for (Map.Entry<Integer, Integer> entry: entryList) {
            for (int i = 0; i < entry.getValue(); i++) {
                arr[index++] = entry.getKey();
            }
        }
        
        // Print Array
        for (int k = 0; k < arr.length; k++) {
        	if (k == arr.length - 1) {
        		System.out.println(arr[k] + " ");
        	}else {
            System.out.print(arr[k] + " ");
        	}
        }
    }
	
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 2,2, 4, 5, 6, 7, 7, 7, 7,7};
		customSort(arr);

	}

}
