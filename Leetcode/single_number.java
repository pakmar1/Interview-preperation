/* solution using a HashMap */

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                continue;
            }
            map.put(nums[i],1);
        }
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==1){
                return nums[i];
            }
        }
        return -1;
    }
}

/* solution without using an extra data structure - using XOR operation */

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result ^= num;
        }
        return result;
    }
}
