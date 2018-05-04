package leetcodeAbove200;

public class NumofIslandsUnionFind {
	/* time: O(MNlog(MN) space: O(MN)*/ 
	 public static int numIslands(char[][] grid) {
	        if (grid == null || grid.length == 0) return 0;
	        
	        int m = grid.length;
	        int n = grid[0].length;
	        
	        UnionFind uf = new UnionFind(m * n);
	        /* The following loop checks its neighbors and unites them if both are 1 */
	        for (int row = 0; row < m; row++) {
	            for (int col = 0; col < n; col++) {
	                if (grid[row][col] == '0') continue;
	                // check all 4 neighbors and do union if neighbor is also 1
	                if (row + 1 < m && grid[row + 1][col] == '1') 
	                    uf.union(row * n + col, (row + 1) * n + col);
	                if (row - 1 >= 0 && grid[row - 1][col] == '1')
	                    uf.union(row * n + col, (row - 1) * n + col);
	                if (col + 1 < n && grid[row][col + 1] == '1')
	                    uf.union(row * n + col, row * n + col + 1);
	                if (col - 1 >=0 && grid[row][col - 1] == '1')
	                    uf.union(row * n + col, row * n + col - 1);
	            }
	        }
	        
	        int count = 0;
	        int[] arr = new int[m * n]; // to count the freq of each set
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (grid[i][j] == '1') {
	                    int x = uf.find(i * n + j);
	                    if (arr[x] == 0) {
	                        count++;
	                        arr[x]++;
	                    }
	                    else
	                        arr[x]++;
	                }
	            }
	        }
	        return count;
	    }

	public static void main(String[] args) {
		char[][] a = new char[][] {{'1', '1', '0', '0', '0'},
            { '0', '1', '0', '0', '1' },
            { '1', '0', '0', '1', '1' },
            { '0', '0', '0', '0', '0' },
            { '1', '0', '1', '0', '1' }};
        System.out.print(numIslands(a)); // 6
	}

}
class UnionFind {
    int[] rank, parent;
    int n;
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        this.n = n;
        makeSet();
    }
    
    void makeSet() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
    
    public void union(int i, int j) {
        int irep = find(i);
        int jrep = find(j);
        if (irep == jrep) return;
        
        int irank = rank[irep];
        int jrank = rank[jrep];
        if (irank < jrank) {
            parent[irep] = jrep;
        }
        else if (irank > jrank) {
            parent[jrep] = irep;
        }
        else {
            // same rank
            parent[irep] = jrep;
            rank[jrep]++;
        }
    }
}
