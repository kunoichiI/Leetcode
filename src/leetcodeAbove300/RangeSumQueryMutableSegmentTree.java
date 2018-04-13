package leetcodeAbove300;
/*
 * 307. Range Sum Query - Mutable
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

	The update(i, val) function modifies nums by updating the element at index i to val.
	Example:
	Given nums = [1, 3, 5]
	
	sumRange(0, 2) -> 9
	update(1, 2)
	sumRange(0, 2) -> 8
	Note:
	The array is only modifiable by the update function.
	You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class RangeSumQueryMutableSegmentTree {
	int[] tree;
    int n;
    /* use original nums to construct segment Tree, size is 2N */
    public RangeSumQueryMutableSegmentTree(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }
    
    public void buildTree(int[] nums) {
        // insert leaf nodes in tree
        for (int i = 0; i < n; i++) 
            tree[n + i] = nums[i];
         
        // build the tree by calculating
        // parents
        for (int i = n - 1; i > 0; --i) 
            tree[i] = tree[i << 1] +
                      tree[i << 1 | 1]; // (i << 1 | 1) same as i * 2 + 1
        
        // same as below
//        for (int i = n, j = 0;  i < 2 * n; i++,  j++) 
//            tree[i] = nums[j];
//        
//        for (int i = n - 1; i > 0; --i)
//            tree[i] = tree[i * 2] + tree[i * 2 + 1];
//        }
    }
    
    public void update(int i, int val) {
        // set value at position p
        tree[i + n] = val;
        i = i + n;
         
        // move upward and update parents
        for (int j = i; j > 1; j >>= 1)
            tree[j >> 1] = tree[j] + tree[j^1]; // j ^ 1 bitwise XOR. so if j is even, tree[j ^ 1] gets odd
        // tree[j^1] after tree[j]  tree[4] = tree[8] + tree[9] 
        // if j is odd, tree[j ^ 1] gets even( j ^ 1 ahead of j) tree[5] = tree[10] + tree[9]
    }
    
    public int sumRange(int i, int j) {
        i += n;
        j += n;
        int sum = 0;
        while (i <= j) {
            if (i % 2 == 1) {
                sum += tree[i];
                i++;
            }
            if (j % 2 == 0) {
                sum += tree[j];
                j--;
            }
            i /= 2;
            j /= 2;
        }
        return sum;
    }
}
