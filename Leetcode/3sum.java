import java.util.*; 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i+2 < len; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            if(nums[i] + nums[i+1] +nums[i+2] > 0 ) continue;
            if(nums[i] + nums[len-2] + nums[len-1] < 0) continue;
            int j = i+1, k = len-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(j < k && nums[k] == nums[k-1]) k--;
                    j++;  k--;
                }else if(sum < 0) {
                    j++;
                }else {
                    k--;
                }
            }
        }
        return res;
    }
}
