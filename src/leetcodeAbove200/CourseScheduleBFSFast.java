package leetcodeAbove200;
// ref: http://www.cnblogs.com/yrbbest/p/4493547.html
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// BFS-based solution, much faster!
public class CourseScheduleBFSFast {
	/* time: O(V + E), space: O(E) */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0) return true;
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<Integer>());
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()) {
            int num = q.poll();
            res.add(num);
            for (int i: graph.get(num)) {
                indegree[i]--;
                if (indegree[i] == 0) q.offer(i);
            }
        }
        return res.size() == numCourses;
    }
}
