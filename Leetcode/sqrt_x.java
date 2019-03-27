class Solution {
    public int mySqrt(int x) {
        double next = x;   
        while(Math.abs(next*next - x) > 0.1) 
        {
            next = next - ((next*next - x)/(2*next));
        }
        return (int) next;
    }
}
