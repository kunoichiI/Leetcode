package leetcode;
//Given two Binary Search Trees, find common nodes in them. In other words, find intersection of two BSTs.
//
//Example:
//        5
//      /   \
//     1    10
//   / \    / 
//  0   4   7
//          \
//           9

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
//             5 (root1)
//         /      \
//        1       10
//      /  \     /   
//     0   4    7
//               \
//                9


//          10 (root2)
//         / \
//        7   20
//       / \
//      4   9

// Output: 4, 7, 9, 10  Do it in o(n) time and limited space
class aNode {
	int key;
	aNode left, right;
	public aNode(int key) {
		this.key = key;
	}
	public void print() {
		System.out.print(" Node is:" + key);
	}
}
public class IntersectionOfTwoBST {
	private static Set<Integer> set = new HashSet<>();
	public void printIntersection(aNode root1, aNode root2) {
		if (root1 == null || root2 == null) return;
		
		if (root1.key < root2.key) {
			printIntersection(root1, root2.left);
			printIntersection(root1.right, root2);
		} else if (root1.key > root2.key) {
			printIntersection(root1.left, root2);
			printIntersection(root1, root2.right);
		} else { // Common node found
			//System.out.println("find " + root1.key);
			set.add(root1.key);
			printIntersection(root1.left, root2.left);
			printIntersection(root1.right, root2.right);
		}
	}
	
	
	public static void main(String[] args) {
		// build two BSTs
		aNode root1 = new aNode(5);
		root1.left = new aNode(1);
		root1.right = new aNode(10);
		root1.left.left = new aNode(0);
		root1.left.right = new aNode(4);
		root1.right.left = new aNode(7);
		root1.right.left.right = new aNode(9);
		
		aNode root2 = new aNode(10);
		root2.left = new aNode(7);
		root2.right = new aNode(20);
		root2.left.left = new aNode(4);
		root2.left.right = new aNode(9);
		
		IntersectionOfTwoBST it = new IntersectionOfTwoBST();
		it.printIntersection(root1, root2);
		System.out.print("We have found following common nodes: \n");
		for (int a: set) {
			System.out.println(a + " ");
		}
	}

}
