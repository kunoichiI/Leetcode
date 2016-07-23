package leetcode;


//Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
//
//Note:
//If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
//All airports are represented by three capital letters (IATA code).
//You may assume all tickets form at least one valid itinerary.
//Example 1:
//tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
//Example 2:
//tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
//Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinery {

	public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> hashmap = new HashMap<String, PriorityQueue<String>>();
        List<String> list = new ArrayList<String>();
        String cur = "JFK";
        int length = tickets.length;
        for (int i = 0; i < length; i++) {
            if (!hashmap.containsKey(tickets[i][0])) {
                hashmap.put(tickets[i][0], new PriorityQueue<String>());
            }
            hashmap.get(tickets[i][0]).add(tickets[i][1]);
        }
        dfs(cur, hashmap, list);
        Collections.reverse(list);
        return list;
    }
    public void dfs(String cur, Map<String, PriorityQueue<String>> hashmap, List<String> list) {
        while (hashmap.containsKey(cur) && !hashmap.get(cur).isEmpty()) {
            dfs(hashmap.get(cur).poll(), hashmap, list);
        }
        list.add(cur);
    }
	
	public static void main(String[] args) {
		ReconstructItinery ri = new ReconstructItinery();
		String[][] tickets = new String[][]{
			{"JFK", "SFO"},
			{"JFK", "ATL"},
			{"SFO", "ATL"},
			{"ATL", "JFK"},
			{"ATL", "SFO"}
		};
		List<String> res = ri.findItinerary(tickets);
		Iterator<String> iterator = res.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + "->");
		}
	}

}
