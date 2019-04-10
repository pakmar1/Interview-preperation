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
