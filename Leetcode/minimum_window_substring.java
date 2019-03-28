class Solution {
    public String minWindow(String s, String t) {
        
        int[] m = new int[128];
        
        for (char c : t.toCharArray()) m[c]++;
        
        int cnt = t.length(), start = 0, end = 0, head = 0, d = Integer.MAX_VALUE;
        
        while (end < s.length()) {
            
            if (m[s.charAt(end++)]-- > 0) cnt--;
            
            while (cnt == 0) {
                if (end - start < d) {
                    head = start;
                    d = end - start;
                }
                if (m[s.charAt(start++)]++ == 0) cnt++;
            }
        }
        
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}
