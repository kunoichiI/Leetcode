package leetcodeAbove100;

import java.util.HashMap;
import java.util.Map;

public class CloneGraphDFS { // 4ms AC! Fastest solution
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return dfs(map, node);
    }
    
    public UndirectedGraphNode dfs(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
        if (node == null) return null;
        
        if (map.containsKey(node)) { // 这一步充当了DFS里检查visited node
            return map.get(node);
        }
        // 下面是unvisited node，对这些node，进行visit，并加入所有邻居nodes
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        for (UndirectedGraphNode neighbor: node.neighbors) {
            clone.neighbors.add(dfs(map, neighbor));
        }
        return clone;
    }
    /*
     * 超级优雅的DFS解法，base case 为node == null 和map containsKey（node）
     * 然后对每一个visited node， 把dfs得到的node加入其clone node的neighbors里
     * 最后返回clone 起始点。
     */
}
