class Solution {
    public int trap(int[] height) {
        int result=0;
        if(height.length==0) return result;
        int side1=height[0], side2=height[height.length-1], max=height[0], peak=0;
        for(int i=0; i<height.length; i++) {
            if(height[i]>max){
                max=height[i];
                peak=i;
            }
        }
		// left hand of the peak
        for(int i=0; i<peak; i++){
            if(height[i]>=side1) side1=height[i];
            else result+=side1-height[i];
        }
		
		// right hand of the peak
        for(int i=height.length-1; i>peak; i--){
            if(height[i]>=side2) side2=height[i];
            else result+=side2-height[i];
        }
		
        return result;
    }
}
