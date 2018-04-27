package leetcodeAbove100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// slowest speed... not good using DFS and stack. 10 ms, 
public class CloneGraphDFSNonrecursive {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Stack<UndirectedGraphNode> stack = new Stack<>();
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        stack.push(node);
        
        while (!stack.isEmpty()) {
            UndirectedGraphNode n = stack.pop();
            for (UndirectedGraphNode neighbor: n.neighbors) {
                if (!map.containsKey(neighbor)) { // unvisited neighbors
                    stack.push(neighbor);
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        return clone;
    }
	/*
	 * 非递归DFS解法，通常和stack使用。由于stack的LIFO特性，每一个node在pop stack后，其children点会被push
	 * 进栈，然后children的children继续push进栈。所以会exhausively explore children before move to another branch
	 * 在poped node邻居里，对unvisited的node进行入栈，然后记录进map as visited
	 * 对已经visited的node，讲其邻居复制，加入copy node的邻居里。记得要加map.get（neighbor）--》这是copy neighbor
	 */
}	
