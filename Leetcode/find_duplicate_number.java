class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low <= high) {
            int mid = (int) (low + (high - low)/2);
            int count = 0;
            for (int num : nums) {
                if (num <= mid) ++count;
            }
            if (count <= mid) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}

/*
Map<Integer, Integer> map = new HashMap<>();
for(int num:nums) {
    if(map.containsKey(num)) {
        return num;
    }
    else{
        map.put(num,1);
    }
}
*/
