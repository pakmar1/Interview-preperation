class Solution {
    public int climbStairs(int n) {
        
        // base cases
        int n0 = 1;
        int n1 = 1;
        int i = 2;
        int temp = 0;
        
        while(i<=n){
            temp = n0+n1;
            n0 = n1;
            n1 = temp;
            i++;
        }
        
        return n1;
    }
}
/*********************************************************/
/* DP Solution for fibonacci series */
class Solution {
    public int climbStairs(int n) {
        
        if(n < 0)
        return 0;
        if(n == 1) return 1;

        int[] dp = new int[n];

        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i < n; i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n-1];
    }
}
