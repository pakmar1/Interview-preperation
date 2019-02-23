class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for(int i = 0;i<nums.length;i++) {
            if(nums[i]==0){
                zeros++;
            }
            else if(nums[i]==1){
                ones++;
            }
            else{
                twos++;
            }
        }
        
        for(int j=0;j<nums.length;j++) {
            if(zeros>0){
                nums[j]=0;
                zeros--;
                continue;
            }    
            if(ones>0){
                nums[j]=1;
                ones--;
                continue;
            }
            if(twos>0){
                nums[j]=2;
                continue;
            }
        }
        
    }
}
