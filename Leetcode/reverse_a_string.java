class Solution {
    public String reverseString(String s) {
        
        
        char[] sArr = s.toCharArray();
        
        char temp;
 
        StringBuffer sBuffer = new StringBuffer(s.length());
        for (int i=s.length()-1; i>=0; i--) {
            sBuffer.append(s.charAt(i));
        }
        return sBuffer.toString();
    }



    public void reverseStringRecursive(char[] s) {
        int start=0,end=s.length-1;
        reverseRecurse(s,start,end);     
    }
    
    public void reverseRecurse(char[] s, int start, int end) {
        if(start<end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            reverseRecurse(s,start+1,end-1);
        }
    }
    
}
