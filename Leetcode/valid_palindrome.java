class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sc = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>=48 && c<=57 || c >=65 && c<=90 || c>=97 && c <=122) {
                sc.append(s.charAt(i));
            }
        }
        
        String scc = sc.toString().toLowerCase();
        int len = scc.length();
        System.out.println(scc);
        
        for(int i=0;i<len;i++){
            if(scc.charAt(i)!=scc.charAt(len-i-1)){
                return false;
            }
        }
        return true;
        
    }
}
