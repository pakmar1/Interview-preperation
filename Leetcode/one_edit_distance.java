class Solution {
    public boolean isOneEditDistance(String s, String t) {
         if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                // Try replace and insert
                return s.substring(i + 1).equals(t.substring(i + 1)) || s.substring(i).equals(t.substring(i + 1));
            }
        }
        return t.length() - s.length() == 1;
    }
}
