class Solution {
    public int countSubstrings(String s) {
        int size = s.length();
        int count = 0;
        for(int i=0;i<size;i++){
            
            for(int j=i;j<size;j++){
                //System.out.print("new "+s.substring(i,j+1)+"\n");
                if(isPalindrome(s,i,j+1)){
                    count++;
                }
            }
        }
        return count;
    }
    
    boolean isPalindrome(String s, int i, int j){
        
        String str = s.substring(i,j);
        System.out.print(str+" ");
        int start = 0,end=str.length()-1;
        while(start<=end) {
            if(str.charAt(start)!=str.charAt(end)){
                //System.out.println("not pali");
                return false;
            }
            start++;
            end--;

        }
        //System.out.println();
        
        
        
        return true;
    }
}
