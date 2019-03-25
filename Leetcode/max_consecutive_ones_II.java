class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int current = 0;
        int ifFlipCurrent = 0;
        int ifFlipMax = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                ifFlipCurrent++;
                current++;
            } else {
                ifFlipCurrent = current + 1;
                current = 0;
            }
            
            ifFlipMax = Math.max(ifFlipMax, ifFlipCurrent);
        }
        
        return ifFlipMax;
    }
}
