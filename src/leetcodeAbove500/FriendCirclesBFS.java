package leetcodeAbove500;

import java.util.ArrayDeque;
import java.util.Queue;

public class FriendCirclesBFS {
	public static int findCircleNum(int[][] M) {
        int n = M.length, res = 0;
        
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            q.offer(i);
            while (!q.isEmpty()) {
                int k = q.poll();
                visited[k] = true;
                for (int j = 0; j < n; j++) {
                    if (M[k][j] == 1 && !visited[j])
                        q.offer(j);
                }
            }
            ++res;
        }
        return res;
    }
	public static void main(String[] args) {
		int[][] M = {{1, 1, 0, 0 }, {1, 1, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}};
		System.out.print(findCircleNum(M)); // => 1
	}
	/*
	 * 思路同DFS，但这个解法速度更慢比起call stack。。
	 */
}
