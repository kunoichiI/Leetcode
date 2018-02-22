package leetcodeAbove100;

import java.util.*;

//133. Clone Graph
//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
//
//
//OJ's undirected graph serialization:
//Nodes are labeled uniquely.
//
//We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
//As an example, consider the serialized graph {0,1,2#1,2#2,2}.
//
//The graph has a total of three nodes, and therefore contains three parts as separated by #.
//
//First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
//Second node is labeled as 1. Connect node 1 to node 2.
//Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
//Visually, the graph looks like the following:
//
//       1
//      / \
//     /   \
//    0 --- 2
//         / \
//         \_/

public class CloneGraph {
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode start = new UndirectedGraphNode(node.label);
		map.put(node, start);
		
		Queue<UndirectedGraphNode> q = new LinkedList<>();
		q.add(node);
		
		while (!q.isEmpty()) {
			while (!q.isEmpty()) {
	            UndirectedGraphNode curr = q.poll(); // cur -> copy in map
	            List<UndirectedGraphNode> currNeighbors = curr.neighbors; 
	 
	            for(UndirectedGraphNode aNeighbor: currNeighbors){ // copy neighbors to copy node
	                if(!map.containsKey(aNeighbor)){
	                    UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
	                    map.put(aNeighbor,copy);
	                    map.get(curr).neighbors.add(copy);
	                    q.add(aNeighbor);
	                }else{
	                    map.get(curr).neighbors.add(map.get(aNeighbor));
	                }
	            }
	 
	        }
		}
		return start;
	}
	
	public static void main(String[] args) {
		UndirectedGraphNode head = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		head.neighbors.addAll(Arrays.asList(node1, node2));
		node1.neighbors.addAll(Arrays.asList(head, node2));
		node2.neighbors.add(node2);
		
		UndirectedGraphNode start = cloneGraph(head);
		System.out.println("copy head is: " + start.label);
	}

}

class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
