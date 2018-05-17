package leetcodeAbove200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleIIBFSTopo {
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || numCourses == 0) return new int[]{0};
        
        Map<Integer, List<Integer>> nodes = new HashMap<>();
        int[] degrees = new int[numCourses];
        
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < numCourses; i++) nodes.put(i, new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            degrees[prerequisites[i][0]]++;
            nodes.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        System.out.println("map is: " + nodes);
        System.out.println("degree is: " + degrees);
        
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) q.add(i);
        }
        
        int[] ret = new int[numCourses];
        int len = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ret[len++] = node;
            
            for (int i: nodes.get(node)) {
                degrees[i]--;
                if (degrees[i] == 0) q.add(i);
            }
        }
        
        return (len == numCourses) ? ret : new int[0];
        
    }
	public static void main(String[] args) {
		int[] order = findOrder(2, new int[][]{});
		System.out.print(Arrays.toString(order));
	}

}
