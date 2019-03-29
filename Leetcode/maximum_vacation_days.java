class Solution {
    int n;
    
    public int maxVacationDays(int[][] flights, int[][] days) {
        
        int K = days[0].length-1;
        n=flights.length;
        
        return dfs(0, -1, K, flights, days, new int[days.length][days[0].length]);
    }
    
    int dfs(int city, int k, int K, int[][] flights, int[][] days, int[][] dp) {
            
        if(k!= -1 && dp[city][k] != 0) return dp[city][k];

        if(k==K) return days[city][k];

        int max = 0;

        //for each connected flight
        for(int j = 0;j<n;j++) if(flights[city][j] == 1){
            max = Math.max(max, dfs(j, k+1, K, flights, days, dp));
        }
        //stay at the same city
        max = Math.max(max, dfs(city, k+1, K, flights, days, dp));

        //at the start we don't include "zero" city
        if(k==-1) return max;

        dp[city][k] = max + days[city][k];
        
        return max + days[city][k];
    }
}
