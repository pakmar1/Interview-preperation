class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        int p = -1;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                chars[++p] = c;
            }
            else if (p == -1) {
                return false;
            }
            else if (c == ')' && chars[p] == '(') {
                p--;
            }
            else if (c == '}' && chars[p] == '{') {
                p--;
            }
            else if (c == ']' && chars[p] == '[') {
                p--;
            }
            else return false;
        }
        return p == -1;
    }
}
