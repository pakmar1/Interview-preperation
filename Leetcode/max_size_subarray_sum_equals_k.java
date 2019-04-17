class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
        int sum=0,max=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if(!map.containsKey(sum)) {
                map.put(sum,i);
            }
            
            int previousSum = sum - k;
            
            if(map.containsKey(previousSum)) {
                int len = i - map.get(previousSum);
                max = Math.max(max,len);
            }
        }
        
        return max;
    }
}
