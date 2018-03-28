package leetcodeAbove500;
/*
 * 547. Friend Circles
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. 
 * For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. 
 * And we defined a friend circle is a group of students who are direct or indirect friends.

	Given a N*N matrix M representing the friend relationship between students in the class. 
	If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. 
	And you have to output the total number of friend circles among all the students.
	
	Example 1:
	Input: 
	[[1,1,0],
	 [1,1,0],
	 [0,0,1]]
	Output: 2
	Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
	The 2nd student himself is in a friend circle. So return 2.
	Example 2:
	Input: 
	[[1,1,0],
	 [1,1,1],
	 [0,1,1]]
	Output: 1
	Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
	so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
	Note:
	N is in range [1,200].
	M[i][i] = 1 for all students.
	If M[i][j] = 1, then M[j][i] = 1.
 */
public class FriendCirclesDFS {
	public static int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        
        int res = 0;
        int row = M.length;
        boolean[] visited = new boolean[row];
        
        for (int i = 0; i < row; i++) {
            if (visited[i]) continue;
            helper(i, M, visited);
            ++res;
        }
        return res;
    }
    
    private static void helper(int i, int[][] M, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 0 || visited[j]) continue;
            helper(j, M, visited);
        }
    }
	public static void main(String[] args) {
		int[][] M = {{1, 1, 0, 0 }, {1, 1, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}};
		System.out.print(findCircleNum(M)); // => 1
	}
	/*
	 * 解题思路： 这个题虽然也使用DFS，但却和NumOfIslands不一样。 比如 0 - 1 - 3 - 2 这个图里。
	 * 用矩阵表示是  1100
	 * 			   1101
	 * 			   0011
	 *    		   0111 看起来有两个groups，但其实原图只有一个group
	 *    所以思路为： 用单维布尔数列记录friend有没有被visit过
	 *    loop body，然后对unvisited friend进行visit，并遍历其朋友和朋友的朋友直到没有indirect friend为止，cnt增加1
	 *    
	 */
}
