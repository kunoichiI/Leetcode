package leetcodeAbove200;

import java.util.*;
//210. Course Schedule II 
//There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
//
//For example:
//
//2, [[1,0]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
//
//4, [[1,0],[2,0],[3,1],[3,2]]
//There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

public class CourseScheduleII {
	private int label;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        this.label = numCourses - 1;
         
        int[] result = new int[numCourses];
         
        // No prerequisites
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
             
            return result;
        }
         
        // Convert the edge list to adj. list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : prerequisites) {
            if (adjList.containsKey(edge[1])) {
                List<Integer> neighbors = adjList.get(edge[1]);
                neighbors.add(edge[0]);
                adjList.put(edge[1], neighbors);
            } else {
                List<Integer> neighbors = new ArrayList<Integer>();
                neighbors.add(edge[0]);
                adjList.put(edge[1], neighbors);
            }
        }
         
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (toplogicalSorting(i, visited, adjList, result) == false) {
                return new int[0];
            }
        }
         
        return result;
    }
     
    private boolean toplogicalSorting(int vertexId, int[] visited, 
            Map<Integer, List<Integer>> adjList,
                                   int[] result) {
        // Has been visited
        if (visited[vertexId] == -1) {
            return false;
        }
         
        // Has been added into the list
        if (visited[vertexId] == 1) {
            return true;
        }
         
        visited[vertexId] = -1;
         
        List<Integer> neighbors = adjList.get(vertexId);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (toplogicalSorting(neighbor, visited, 
                    adjList, result) == false) {
                    return false;
                }
            }
        }
         
        result[label--] = vertexId;
        visited[vertexId] = 1;
         
        return true;
                                        
    }
}
