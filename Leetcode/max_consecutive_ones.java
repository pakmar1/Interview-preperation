class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==0) return 0;
        int count=0;
        int maxCount=0;
        for(int i=0;i<nums.length;i++){
            count++;
            if(nums[i]==0){
                count=0;
            }
            if(count>maxCount){
                maxCount=count;
            }
            
        }
        return maxCount;
    }
}
