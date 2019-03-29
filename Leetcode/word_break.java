class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int maxLen = Integer.MIN_VALUE;
        int minLen = Integer.MAX_VALUE;
        for (String word: wordDict) {
            maxLen = Math.max(maxLen, word.length());
            minLen = Math.min(minLen, word.length());
        }
        
        boolean[] r = new boolean[s.length() + 1];
        r[0] = true;
        for (int i = 1; i < r.length; i++) {
            for (int j = minLen - 1; j < Math.min(maxLen, i); j++) {
                String temp = s.substring(i - j - 1, i);
                if (wordDict.contains(temp)) {
                    r[i] = r[i] || r[i - j - 1];
                    if (r[i]) {
                        break;
                    }
                }
            }
        }
        
        return r[r.length - 1];
    }
}
