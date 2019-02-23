class Solution {
    public int maxArea(int[] height) {
        
        
        int current = height[0];
        int total = 0;
        int high = height[0];
        
        int i = 0,steps=0,j=height.length-1;
        
        int ans =0;
        while(i<j) {
            
            if(height[i] < height[j]) {
                total = height[i]*(j-i);
            }
            else {
                total = height[j]*(j-i);
            }
            if(total>ans){
                ans = total;
            }
            
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        
        return ans;
        
    }
}
