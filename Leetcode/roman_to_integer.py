class Solution:
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        num = 0
        for i in range(len(s)):
            if s[i] == 'I':
                if i<len(s)-1 and (s[i+1] == 'V' or s[i+1] =='X'):
                    num-=1
                    continue
                num+= 1
                
            elif s[i] == 'V':
                num+= 5
            elif s[i] == 'X':
                if i<len(s)-1 and (s[i+1] == 'L' or s[i+1] =='C'):
                    num-=10
                    continue
                num+= 10
                    
            elif s[i] == 'L':
                num+= 50
            elif s[i] == 'C':
                if i<len(s)-1 and (s[i+1] == 'D' or s[i+1] =='M'):
                    num-=100
                    continue
                num+= 100
                
            elif s[i] == 'D':
                num+= 500
            elif s[i] == 'M':
                num+= 1000
            
        return num
