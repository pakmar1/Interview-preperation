class Solution {
    
    int[] nums;
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        
        return quickselect(0, size - 1, size - k);
    }
    
    public int quickselect(int left, int right, int k) {
        if (left == right) return this.nums[left];
        
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);
        
        pivot_index = partation(left, right, pivot_index);
        
        if (pivot_index == k) {
            return this.nums[pivot_index];
        } else if (pivot_index > k) {
            return quickselect(left, pivot_index - 1, k);
        } else {
            return quickselect(pivot_index + 1, right, k);
        }
    }
    
    public int partation(int left, int right, int pivot_index) {
        int pivot = this.nums[pivot_index];
        
        swap(pivot_index, right);
        int division_index = left;
        for (int i = left; i < right; i++) {
            if (this.nums[i] < pivot) {
                swap(division_index, i);
                division_index++;
            }
        }
        
        swap(division_index, right);
        return division_index;
    }
    
    
    public void swap(int a, int b) {
        int temp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = temp;
    }

    
/*               
         PriorityQueue<Integer> pq = new PriorityQueue<>();
         for (int n : nums) {
             pq.add(n);
             if (pq.size() > k) {
                 pq.poll();
             }
         }
        
         return pq.peek();
*/
}
