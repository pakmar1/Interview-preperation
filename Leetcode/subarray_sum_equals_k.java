class Solution {
    public int subarraySum(int[] nums, int k) {
        int temp = 0;
        int ans = 0;
        for(int i = 0;i<nums.length;i++) {
            temp = 0;
            for(int j=i;j<nums.length;j++) {
                
                temp+=nums[j];
                if(temp == k) {
                    ans++;
                    continue;
                }
            }
        }
        return ans;
    }
}
