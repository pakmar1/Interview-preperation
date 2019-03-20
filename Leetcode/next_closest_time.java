class Solution {
    public String nextClosestTime(String time) {
        char[] digits = new char[4];
        digits[0] = time.charAt(0);
        digits[1] = time.charAt(1);
        digits[2] = time.charAt(3);
        digits[3] = time.charAt(4);
        Arrays.sort(digits);
        
        char[] nextTime = time.toCharArray();
        
        nextTime[4] = findNextValidDigit(digits, time.charAt(4), '9');
        if (nextTime[4] > time.charAt(4)) {
            return String.valueOf(nextTime);
        }
        
        nextTime[3] = findNextValidDigit(digits, time.charAt(3), '5');
        if (nextTime[3] > time.charAt(3)) {
            return String.valueOf(nextTime);
        }
        
        char maxDigit = time.charAt(0) == '2' ? '3' : '9';
        nextTime[1] = findNextValidDigit(digits, time.charAt(1), maxDigit);
        if (nextTime[1] > time.charAt(1)) {
            return String.valueOf(nextTime);
        }
        
        nextTime[0] = findNextValidDigit(digits, time.charAt(0), '2');
        
        return String.valueOf(nextTime);
    }
    
    private char findNextValidDigit(char[] digits, char digit, char maxDigit) {
        int currentIndex = -1;
        for (int i = 0; i < digits.length; i++) {
            if (digit == digits[i]) {
                currentIndex = i;
            }
        }
        
        currentIndex = (currentIndex + 1) % digits.length;
        
        if (digits[currentIndex] > maxDigit) {
            return digits[0];
        }
        
        return digits[currentIndex];
    }
   
}
