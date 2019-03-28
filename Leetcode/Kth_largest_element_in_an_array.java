class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if( nums == null || nums.length == 0 || nums.length < k )return 0;
        
    	partition(nums,0,nums.length-1, nums.length-k);
    	//System.out.println(nums[nums.length-k]);
    	return nums[nums.length-k];
    }
    
    public void partition(int[] nums, int start, int end, int k) {
    	if( start >= end) return;
    	int i = start;
    	int j = end;
        int mid = start + (end - start)/2;
        //int pivot = choosePivot(nums[mid], nums[start], nums[end]);
        int pivot = nums[mid];
    	while(i <= j) {
    		while(i <= j && nums[i] <pivot ) {
    			i ++;
    		}
    		
    		while( j >= i && nums[j] > pivot) {
    			j --;
    		}
    		
    		if(i <= j) {
    			int tmp = nums[i];
    			nums[i] = nums[j];
    			nums[j] = tmp;
    			i++;
    			j--;
    		}

    	}
		i--;
		j++;
		if(k<= i) {
			partition(nums,start,i,k);

		}else {
			partition(nums,i+1,end,k);			
		}
    }
}
