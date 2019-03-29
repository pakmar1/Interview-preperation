class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        int pre = 1, prepre = 1;
        for(int i = 2; i <= s.length(); i++) {
            int cur = 0;
            int v1 = Integer.valueOf(s.substring(i-1, i));
            int v2 = Integer.valueOf(s.substring(i-2, i));
            
            if(v1 > 0 && v1 < 10) cur += pre;
            if(v2 >= 10 && v2 <= 26) cur += prepre;

            prepre = pre;
            pre = cur;
        }
        return pre;
    }
}
