class Solution {
    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int column = M[0].length;
        int[][] ans = new int[row][column];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                int sum = M[i][j];
                int count = 1;
                
                //count the sum of the three numbers at row i-1
                if(i-1 >= 0){
                    sum += M[i-1][j];
                    count++;
                    if(j-1 >= 0){
                        sum += M[i-1][j-1];
                        count++;
                    }
                    if(j+1 < column){
                        sum += M[i-1][j+1];
                        count++;
                    }
                }
                
                //count the sum of the three numbers at row i+1
                if(i+1 < row ){
                    sum += M[i+1][j];
                    count++;
                    if(j-1 >= 0){
                        sum += M[i+1][j-1];
                        count++;
                    }
                    if(j+1 < column){
                        sum += M[i+1][j+1];
                        count++;
                    }
                }
                
                //count the sum of the two numbers at row i
                if(j-1 >= 0){
                    sum += M[i][j-1];
                    count++;
                    }
                
                if(j+1 < column){
                    sum += M[i][j+1];
                    count++;
                    }
                
                ans[i][j] = sum/count;
            }
        }
        return ans;
    }
}
