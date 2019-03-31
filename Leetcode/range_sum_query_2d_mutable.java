class NumMatrix {
    int [][] sumByLine;
    int nRows;
    int nCols;
        
    public NumMatrix(int[][] matrix) {
        nRows = matrix.length;
        nCols = nRows == 0 ? 0 : matrix[0].length;
        sumByLine = new int[nRows][nCols];
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                sumByLine[i][j] = prevSum(i, j) + matrix[i][j];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int delta = val - (sumByLine[row][col] - prevSum(row, col));
        for (int j = col; j < nCols; j++) {
            sumByLine[row][j] += delta;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            res += sumByLine[i][col2] - prevSum(i, col1);
        }
        return res;
    }
    
    private int prevSum(int row, int col) {
        return col == 0 ? 0 : sumByLine[row][col - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
