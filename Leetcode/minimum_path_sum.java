class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] memo = new int[row][col];
        memo[0][0] = grid[0][0];
        
        for(int i = 1; i < row; i++)
            memo[i][0] = memo[i-1][0]+grid[i][0];
        
        for(int i = 1; i < col; i++)
            memo[0][i] = memo[0][i-1]+grid[0][i];
        
        for(int i = 1; i < row; i++)
            for(int j = 1; j < col; j++)
                memo[i][j] = Math.min(memo[i][j-1], memo[i-1][j])+grid[i][j];
        
        return memo[row-1][col-1];
    }
}
