class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0) return res;
        if(nums1.length * nums2.length < k){
            for(int n1: nums1){
                for(int n2: nums2){
                    res.add(new int[]{n1, n2});
                }
            }
            return res;
        }
        
        int x = nums1.length;
        int y = nums2.length;
        int lo = nums1[0] + nums2[0]; // minimum sum
        int hi = nums1[x-1] + nums2[y-1]; // maximum sum
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int start = y - 1;
            int count = 0;
            for(int n:nums1){
                while(start >= 0 && n + nums2[start] > mid){
                    start--;
                }
                count+=start+1;
            }
            if(count>=k){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        
        int n = 0;
        int[] mem = new int[x];
        for(int i = 0, j=0; i < x;i++,j=0){
            while(j < y && nums1[i]+nums2[j] < lo){
                res.add(new int[] {nums1[i],nums2[j]});
                n++;
                j++;
            }
            mem[i] = j;
        }
        
        for(int i = 0, j =0; i < x && n < k; i++){
            j = mem[i];
            while(j < y && n < k && nums1[i]+nums2[j]==lo){
                res.add(new int[] {nums1[i],nums2[j]});
                n++;
                j++;  
            }
        }
        
        return res;
    }
}
