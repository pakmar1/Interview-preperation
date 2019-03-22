class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length-1;
        digits[n] += 1;
        int i=n;
        while(digits[i]==10 && i>0){
            digits[i]=0;
            digits[i-1] +=1;
            i--;
        }
        if(digits[0]==10){
            int[] newDigits=new int[digits.length+1];
            newDigits[0]=1;
            return newDigits;
        }
        return digits;
    }
}
