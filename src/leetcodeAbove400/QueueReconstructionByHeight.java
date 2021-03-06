package leetcodeAbove400;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 406. Queue Reconstruction by Height
 * Suppose you have a random list of people standing in a queue. 
 * Each person is described by a pair of integers (h, k), 
 * where h is the height of the person and k is the number of people in front of this person 
 * who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

	Note:
	The number of people is less than 1,100.
	
	
	Example
	
	Input:
	[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	
	Output:
	[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
        int m = people.length;
        int[][] helper = new int[m][2];
        Arrays.sort(people, (int[] p1, int[] p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            tmp.add(people[i][1], people[i]);
        }
        for (int i = 0; i < m; i++) {
            helper[i][0] = tmp.get(i)[0];
            helper[i][1] = tmp.get(i)[1];
        }
        return helper;
    }
	/*
	 * 这个的实现原理到底是什么？？
	 */
}
