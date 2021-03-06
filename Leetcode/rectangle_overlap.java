class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int width,height;
        
        width = Math.min(rec1[2],rec2[2]) - Math.max(rec1[0],rec2[0]);
        height = Math.min(rec1[3],rec2[3]) - Math.max(rec1[1],rec2[1]);
        if(width<=0 || height<=0) return false;
        
        return true;
    }
}
