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
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for (int[] pre : prerequisites) {
            if (!adjList.containsKey(pre[1]))
                adjList.put(pre[1], new ArrayList<Integer>());
            adjList.get(pre[1]).add(pre[0]);
        }
        System.out.println("the graph is: " + adjList);
        int[] visited = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (hasCircle(i, visited, adjList, stack))
               return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
        		list.add(stack.pop());
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    
    public static boolean hasCircle(int i, int[] visited,  Map<Integer, List<Integer>> adjList, Stack<Integer> stack) {
        if (visited[i] == -1)
            return true;
        if (visited[i] == 1)
            return false;
        
        visited[i] = -1;
        List<Integer> neighbors = adjList.get(i);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (hasCircle(neighbor, visited, adjList, stack))
                    return true;
            }
        }
        visited[i] = 1;
        stack.push(i);
        return false;
    }
    
    public static void main(String[] args) {
    		int[][] prerequisites1 = {
    				{1, 0}, {2, 0}, {3, 1}, {3, 2}
    		};
    		int[] arr = findOrder(4, prerequisites1); // [0, 1, 3, 2] 
    		System.out.println(Arrays.toString(arr));
    }
}
