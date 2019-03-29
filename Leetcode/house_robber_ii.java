class Solution {
    public int rob(int[] nums) {
        if(nums.length ==0) return 0;
        if(nums.length ==1) return nums[0];
        int first = helper(Arrays.copyOfRange(nums, 0,nums.length-1));
        int second = helper(Arrays.copyOfRange(nums, 1,nums.length));
        return Math.max(first,second);
    }
    
    public int helper(int[] nums){
        int[] out = new int[nums.length];
        if(nums.length ==0) return 0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                out[0] = nums[0];
                continue;
            }
            if(i==1){
                out[1] = Math.max(nums[0], nums[1]);
                continue;
            }
            if(i==2){
                out[2] = Math.max(out[0]+nums[2], out[1]);
                continue;
            }
            out[i] = Math.max(  out[i-2] + nums[i], out[i-1]);
        }
        return out[nums.length-1];
    }
}
