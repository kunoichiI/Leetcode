package interviewQ;

import java.util.Arrays;

//第一轮：定义buddy system为一棵complete binary tree。a complete binary tree is a binary tree in every level, 
// except possibly the last, is completely filled, and all nodes are as far left as possible)
// 一个node可能为0也可能为1 , 它的 value为1，当且仅当它所有的child的value均为1.
//1
//|             
//1             2
//|             |     
//1     2       3     4
//|     |      |    | 
//1 2  3 4    5 6  7 8
//
//实现下列的method。
//1' clearBit(int offset, int len);
//2' setBit(int offset, int len);
public class BuddyBitmapQuestion {
	private int[][] bits; /* this is a representation of a complete binary tree
	bits[x][y] means at x level, y is the index of the node
	*/
	public BuddyBitmapQuestion(int[][] bits) {
		this.bits = bits;
	}
	
	/*
	 * This method calls on each level, starting from the leaf level, then clears each level
	 * offset is the starting index of a node, length is how many nodes we want to clear bits.
	 */
	public void clearBits(int[][] bits, int offset, int length) {
		if (bits == null || bits.length == 0 || offset < 0 || length <= 0) return; // corner cases
		
		int maxLevel = bits.length - 1;
		int left = offset;
		int right = offset + length - 1;
		while (maxLevel >= 0) {
			for (int i = left; i <= right; i++) {
				bits[maxLevel][i] = 0;
			}
			maxLevel--;
			left = left / 2;
			right = right / 2;
		}
	}
	/* Calls on each level, set from offset to length to 1 */
	public void setBits(int[][] bis, int offset, int length) {
		if (bits == null || bits.length == 0 || offset < 0 || length <= 0) return; // corner cases
		
		int maxLevel = bits.length - 1;
		int left = offset;
		int right = offset + length - 1;
		while (maxLevel >= 0 && left <= right) {
			for (int i = left; i <= right; i++) {
				bits[maxLevel][i] = 1;
			}
			/* check the left/right buddy of left node and right node, if left buddy value is 0 or right
			 * buddy value is 0, we cannot set the parent to 1!! (important here)
			 */
			int leftBuddy = left + (left % 2 == 0 ? 1 : -1); // if index is even, we need to get the right buddy
			//System.out.println("leftbuddy: " + leftBuddy);
			int rightBuddy = right + (right % 2 == 0 ? 1: -1); // vice versa
			//System.out.println("rightbuddy: " + rightBuddy);
			// calculate each parent value here
			int p_start = bits[maxLevel][leftBuddy] * bits[maxLevel][left];
			int p_end = bits[maxLevel][rightBuddy] * bits[maxLevel][right];
			left = left / 2;
			right = right / 2;
			maxLevel--;
			if (p_start == 0) 
				left++;
			if (p_end == 0)
				right--;
		}
		
	}
	public static void main(String[] args) {
		int[][] bits1 = {{0}, 
						{0, 1}, 
						{1, 0, 1, 1}, 
						{0, 1, 1, 0}};
		BuddyBitmapQuestion bb = new BuddyBitmapQuestion(bits1);
		bb.clearBits(bits1, 1, 3);
		// After clearing bits, expect a new binary tree like
		/*
		 *         0
		 *       / \
		 *      0   1
		 *     /\   /\
		 *    0  0 1  1
		 *    /\ /\
		 *   0 0 0 0 
		 */   
		System.out.println(Arrays.deepToString(bits1)); // correct
		// After setting bits, expect a new binary tree like below
		/*
		 *         0
		 *       / \
		 *      0   1
		 *     /\   /\
		 *    0  0 1  1
		 *    /\ /\
		 *   0 1 1 0 
		 */
		bb.setBits(bits1, 1, 2);
		System.out.println(Arrays.deepToString(bits1)); // correct
	}

}

// notes: 补充说明
//题目背景：现有一个（逻辑上的）完全二叉树，（数据结构上的）实现方式是二维数组。也就是说二维数组的最后一行是叶子节点，其他行是内部节点。二叉树的节点的值是0或者1。二叉树的节点满足性质：父节点为1，当且仅当两个子节点都是1。二叉树的叶子节点允许被更改，但更改后需要对二叉树的内部节点做必要的更新，以满足前述性质。
//题目要求：实现一个函数setZeros(start, length)，把叶子节点里第start开始的连续length个叶子节点的值置为0，并按照上述性质维护二叉树的内部节点。
//follow up：实现一个函数setOnes(start, length)，把叶子节点里第start开始的连续length个叶子节点的值置为1，并按照上述性质维护二叉树的内部节点。. 
