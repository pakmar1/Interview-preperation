class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] ans = new int[nums.length];
        if (a > 0) {
            int i = 0, j = nums.length - 1;
            for (int k = nums.length - 1; k >= 0; k--) {
                if (solve(nums[i], a, b, c) > solve(nums[j], a, b, c)) {
                    ans[k] = solve(nums[i], a, b, c);
                    i++;
                }
                else {
                    ans[k] = solve(nums[j], a, b, c);
                    j--;
                }
            }
        }
        else if (a < 0) {
            int i = 0, j = nums.length - 1;
            for (int k = 0; k < nums.length; k++) {
                if (solve(nums[i], a, b, c) > solve(nums[j], a, b, c)) {
                    ans[k] = solve(nums[j], a, b, c);
                    j--;
                }
                else {
                    ans[k] = solve(nums[i], a, b, c);
                    i++;
                }
            }
        }
        else if (b > 0) {
            for (int k = 0; k < nums.length; k++) {
                ans[k] = solve(nums[k], a, b, c);
            }
        }
        else if (b < 0) {
            for (int k = nums.length - 1; k >= 0; k--) {
                ans[k] = solve(nums[nums.length - k - 1], a, b, c);
            }
        }
        else {
            for (int k = 0; k < nums.length; k++) {
                ans[k] = c;
            }
        }
        return ans;
    }
    
    public int solve(int x, int a, int b, int c){
        return a*x*x + b*x +c;
    }
}
