class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length<2) return 1;
        int ans = 0;
        int temp = 0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]>nums[i-1]) {
                temp++;
            }
            else {
                temp=0;
            }
            ans = Math.max(temp,ans);
        }
        return ans+1;
    }
}
