class Solution {
    
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        /*
         * Flood FROM the ocean algorithm!
         * run DFS From pacific / atlantic
         */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<int[]>();
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];
        for (int j = 0; j < n; j++) { 
            dfs(pVisited, matrix, 0, j, 0, m, n); 
            dfs(aVisited, matrix, m - 1, j, 0, m, n); 
        }
        for (int i = 0; i < m; i++) { 
            dfs(pVisited, matrix, i, 0, 0, m, n); 
            dfs(aVisited, matrix, i, n - 1, 0, m, n); 
        }
        
        List<int[]> pAndA = new ArrayList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pVisited[i][j] && aVisited[i][j]) {
                    pAndA.add(new int[] {i, j});
                }
            }
        }
        return pAndA;
    }
    
    private void dfs(boolean[][] visited, int[][] matrix, int i, int j, int prev, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || matrix[i][j] < prev) return;
        visited[i][j] = true;
        dfs(visited, matrix, i + 1, j, matrix[i][j], m, n);
        dfs(visited, matrix, i - 1, j, matrix[i][j], m, n);
        dfs(visited, matrix, i, j + 1, matrix[i][j], m, n);
        dfs(visited, matrix, i, j - 1, matrix[i][j], m, n);
    }
    
}
