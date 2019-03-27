class Solution {
    public static int[][] skip = new int[10][10];
    static{
        // we ignore skip[0][0]
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[7][9] = skip[9][7] = 8;
        skip[3][9] = skip[9][3] = 6;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;
    }

    public int numberOfPatterns(int m, int n) {
       
        boolean[] visited = new boolean[10];
        return   countPatterns(m, n, 0, 0, 1, visited) * 4 + //*4 because patter count for 1,3,7 & 9 is same
                 countPatterns(m, n, 0, 0, 2, visited) * 4 + //*4 because patter count for 2,4,6 & 8 is same
                 countPatterns(m, n, 0, 0, 5, visited);
    }

    private int countPatterns(int m, int n, int count, int length, int i, boolean[] visited) {
        visited[i] = true;
        length++;
        
        if(length >= m && length <= n){
            count++;
        }
        
        if(length < n){
            for(int j = 1; j < 10; j++){
                if(!visited[j] && (skip[i][j] == 0 || visited[skip[i][j]])) {
                    count = countPatterns(m, n, count, length, j, visited);
                }
            }
        }
        
        visited[i] = false;
        return count;
    }
}
