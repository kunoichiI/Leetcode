package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequenceRecursive {
	public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        
        StringBuilder sb = new StringBuilder();
        findKthPerm(list, k, sb);
        return sb.toString();
    }
    
    private void findKthPerm(List<Integer> list, int k, StringBuilder sb) {
        if (list.isEmpty()) return;
        
        int n = list.size();
        int count = factorial(n - 1);
        int selected = (k - 1) / count;
        
        sb.append(list.get(selected));
        list.remove(selected);
        
        k = k - count * selected;
        findKthPerm(list, k, sb);
    }
    
    private int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}
