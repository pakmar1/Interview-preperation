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
}
