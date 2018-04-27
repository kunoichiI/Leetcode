package interviewQ;
// Credit Karma phone interview 2018.2.21 
// In a room are N persons. and we will define two people as friends if they're directly or indirectly friends.
// If A is a friend of B, and B is a friend of C,then A is a friend of C too.
// A group of friends is a group of persons where any two persons in the group are friends.
// Given the list of persons that are directly friends, find the smallest group of friends.
// Example: input
// 1 6
// 2 7
// 3 8
// 4 9
// 2 6
// 3 5

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// groups
//  1- 6 - 2 - 7
// 3 - 8 - 5
// 4 - 9
// output: 2, The number of people in smallest group is 2, i.e. [4- 9]
public class FindMinGroup {
	public static int minGroup(List<int[]> friends) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < friends.size(); i++) {
			int p1 = friends.get(i)[0];
			int p2 = friends.get(i)[1];
			
			if (!map.containsKey(p1))
				map.put(p1, new ArrayList<Integer>());
			map.get(p1).add(p2);
			
			if (!map.containsKey(p2))
				map.put(p2, new ArrayList<Integer>());
			map.get(p2).add(p1);
		}// get a map of all direct friends(With everyone as a key)
	
		
		boolean[] visited = new boolean[map.keySet().size() + 1];
		int min = Integer.MAX_VALUE;
		for (int person: map.keySet()) {
			// do dfs on each person
			List<Integer> lst = new ArrayList<>();
			if (!visited[person]) {
				dfs(person, visited, map, lst);
				if (min > lst.size()) {
					min = lst.size();	
				}
			}
			
					
		}
		return min;
	}
	
	public static void dfs(int i, boolean[] visited, HashMap<Integer, List<Integer>> map, List<Integer> lst) {
		System.out.println("visiting: " + i);
		visited[i] = true;
		for (int j : map.get(i)) {
			if (!visited[j])
				dfs(j, visited, map, lst);
		}
		lst.add(i);
	}
	
	public static void main(String[] args) {
		List<int[]> input = new ArrayList<>();
		input.add(new int[]{1, 6});
		input.add(new int[]{2, 7});
		input.add(new int[]{3, 8});
		input.add(new int[]{4, 9});
		input.add(new int[]{2, 6});
		input.add(new int[]{3, 5});
		System.out.println("The min group is : " + minGroup(input));
	}

}
