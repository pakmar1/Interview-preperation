class Solution {
    public int firstMissingPositive(int[] nums) {
        int ans = 1;
        while(true){
            if(!exists(nums,ans)) return ans;
            
            ans++;
        }
        
    }
    
    public boolean exists(int[] nums, int num){
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num){
                return true;
            }
        }
        return false;
    }
}
