class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k < 1) return 0;
        int res = Integer.MIN_VALUE;
        int[] arr = new int[128];
        int size = 0;
        int i=0;
        //once you understand how to use hashmap you should be able to understand this solution
        for(int j=0;j<s.length();j++){
            //if equals 0 means a new char entered. size++;
            if(arr[s.charAt(j)]== 0) size++;
            arr[s.charAt(j)]++;
            //if size is greater than k, when decrease our window size to the point we have exact k Distinct Characters 
            while(size>k){
                res = Math.max(res,j-i);
                //if the size is 1 we know its the last the char, we decrease number in arr and decrease the size
                if(arr[s.charAt(i)] == 1)size--;
                arr[s.charAt(i)]--;
                i++;
            }
            //calculate res when the unique characters are less than k
            res = Math.max(res,j-i+1);
        }
        return res;
    }
}
