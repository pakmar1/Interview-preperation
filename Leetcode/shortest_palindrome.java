class Solution {
    public String shortestPalindrome(String s) {
        
        // for each substring s[0 ... j]
        //     test if substring is a palindrome
        //          if so, this is max P
        // return (N - P) * 2 + P

        int maxP = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isPalindrome(s, 0, i)) {
                maxP = i + 1;
                break;
            }
        }

        return revserse(s.substring(maxP)) + s.substring(0, maxP) + s.substring(maxP);
    }

    private String revserse(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }

    // Pre: 0 <= i <= j <= s.length -1
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
