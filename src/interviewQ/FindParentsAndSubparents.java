package interviewQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Pinterest Karat interview
/*
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:
            
1   2   4
 \ /   / \
  3   5   8
   \ / \   \
    6   7   9


Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.

Sample output (pseudocode):
[
  [1, 2, 4],   // Individuals with zero parents
  [5, 7, 8, 9] // Individuals with exactly one parent
]


// Java
int[][] parentChildPairs = new int[][] {
    {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
    {4, 5}, {4, 8}, {8, 9}
}; */
/*
1 -> [3]  
2 -> [3]
3 - > [6]
4 -> [5, 8]
5 -> [6, 7]
6 -> []
7 -> []
8 -> [9]
9 -> []
first colelction: any node value which doesn't exist in adjacent lists
2nd collection: any node value that has less than two keys 
*/
public class FindParentsAndSubparents {
	public static List<List<Integer>> findParentsAndSubparents(int[][] pairs) {
	    // build a map after preprocessing pair
	    List<Integer> col1 = new ArrayList<>();
	    List<Integer> col2 = new ArrayList<>();
	    Map<Integer, List<Integer>> map = new HashMap<>();
	    for (int[] pair : pairs) {
	      int parent = pair[0];
	      int child = pair[1];
	      if (!map.containsKey(parent)) {
	        map.put(parent, new ArrayList<Integer>());
	      } 
	      map.get(parent).add(child);
	    }
	    // traverse all list for each value of map keys
	    Set<Integer> keys = map.keySet();
	    List<Integer> list = getLists(map);
	    //.collect(Collectors.toList()); System.out.println("merged list is: " + list);
	    // a method to merge all lists into one, list is the merged one
	    for (int key: keys) {
	      if (!keyExist(key, list)) {
	        col1.add(key);
	      }
	    } // end of for, we should get collection1
    	  	List<Integer> uniques = removeDups(list); // remove all occurrences of duplicates here
    	  	//System.out.println("uniques are: " + uniques);
        col2.addAll(uniques);
      
	    List<List<Integer>> res = new ArrayList<>();
	    res.add(col1);
	    res.add(col2);
	    // 1 -> [3] , 2 -> [3]
	    /* if we have 3, we shouldn't add to colelction 2 because it has two parents*/
	    return res;
	    
	  }
	  
	  public static boolean keyExist(int key, List<Integer> list) {
	    return list.contains(key);
	  }
	  
	  public static List<Integer> removeDups(List<Integer> list) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int j : list) {
	    		map.put(j, map.getOrDefault(j, 0) + 1);
	    }
	    //map.entrySet().stream().forEach(System.out::println);
		List<Integer> res = map.entrySet().stream().filter(e -> e.getValue() == 1)
							.map(Map.Entry::getKey)
							.collect(Collectors.toList());
							
	    
	    return res;
	  }
	  
	  public static List<Integer> getLists(Map<Integer, List<Integer>> map) {
	    // merge k lists
	    List<Integer> res = new ArrayList<>();
	    for (int key: map.keySet()) {
	      List<Integer> l = map.get(key);
	      for (int val : l) {
	        res.add(val);
	      }
	    }
	    return res;
	  } // all list elements in one list now!
	public static void main(String[] args) {
		int[][] parentChildPairs = new int[][] { 
		    {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
		    {4, 5}, {4, 8}, {8, 9}
		};
		List<List<Integer>> res = findParentsAndSubparents(parentChildPairs);
		res.stream().forEach(System.out::println);
	}

}
