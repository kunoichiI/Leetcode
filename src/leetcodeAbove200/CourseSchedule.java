package leetcodeAbove200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//207. Course Schedule 
//There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
//For example:
//
//2, [[1,0]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
//
//2, [[1,0],[0,1]]

public class CourseSchedule {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return true;
        }
         
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
         
        // First transform the edge list to adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : prerequisites) {
            if (!adjList.containsKey(edge[1])) {
               adjList.put(edge[1], new ArrayList<Integer>());
            }
            adjList.get(edge[1]).add(edge[0]);
        }
        //System.out.println("map is: " + adjList);
         
        int[] visited = new int[numCourses];
        // Check if the graph contains a circle, if yes, return false.
        for (int i = 0; i < numCourses; i++) {
            if (hasCircles(i, visited, adjList)) {
                return false;
            }
        }
         
        return true;
    }
     
    private static boolean hasCircles(int vertexId, int[] visited, Map<Integer, List<Integer>> adjList) {
        if (visited[vertexId] == -1) {
            return true;
        }
         
        if (visited[vertexId] == 1) {
            return false;
        }
         
        visited[vertexId] = -1;
         
        List<Integer> neighbors = adjList.get(vertexId);
        System.out.println("is there null neighhbors : " + neighbors);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (hasCircles(neighbor, visited, adjList)) {
                    return true;
                }
            }
        }
         
        visited[vertexId] = 1;
         
        return false;
    }
    
    public static void main(String[] args) {
    		int[][] prerequisites1 = {
    				{1, 0}, {2, 1}, {3, 2}, {1, 3}
    		};
    		System.out.println(canFinish(4, prerequisites1)); // false
    		
    		int[][] prerequisites2 = {
    				{1, 0}, {2, 1}
    		};
    		System.out.println(canFinish(3, prerequisites2)); // true
    }
    /*
     * 解题思路：先构建图，hashmap中vertex是key， value是adjacency List
     * 对从0 到n-1的courses，进行cycle检测。本质是一个DFS，每遇到一个vertex，先mark -1，
     * 然后对其所有邻居进行访问， 先检测邻居里有没有已经是-1 的，有的话说明cycle出现
     * 如果没有的话，mark这个vertex为1（说明暂时没有cycle），继续循环直到结束。
     */
}
