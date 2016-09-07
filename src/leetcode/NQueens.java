package leetcode;
// Leetcode 51: NQueens I
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	List<List<String>> res;
	public List<List<String>> solveNQueens(int n) {
		res = new ArrayList<>();
		int[] nqueens = new int[n];
		helper(nqueens, n, 0);
		return res;
	}
	
	public void helper(int[] nqueens, int n, int index) {
		if (index == nqueens.length) {
			List<String> line = new ArrayList<>();
			for (int num: nqueens) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < num; j++) {
					sb.append('.');
				}
				sb.append('Q');
				for (int j = num + 1; j < n; j++) {
					sb.append('.');
				}
				line.add(sb.toString());
			}
			res.add(line);
		}else { // choose next line
			for (int k = 0; k < n; k++) {
				nqueens[index] = k;
				if (isValid(nqueens, index)){
					helper(nqueens, n, index+1);
				}
			}
			
		}
	}
	
	public boolean isValid(int[] nqueens, int i) {
		for(int idx = 0; idx < i; idx++){
            // 检查对角线只要判断他们差的绝对值和坐标的差是否相等就行了
            if(nqueens[idx] == nqueens[i] || Math.abs(nqueens[idx] - nqueens[i]) ==  i - idx){
                return false;
            }
		}
		return true;
	}

	public static void main(String[] args) {
		NQueens nq = new NQueens();
		List<List<String>> res = nq.solveNQueens(8);
		
		for (List<String> l : res) {
			System.out.println(Arrays.asList(l));
		}
	}

}
