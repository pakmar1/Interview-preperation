class Solution:
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        ans = ""
        m = int(num/1000)
        c = int(num % 1000)
        x = int(c % 100)
        c = int((c-x)/100)
        i = int(num % 10)
        x = int((x-i)/10)
        
        print(m,c,x,i)
        
        for mm in range(m):
            ans+='M'
        
        if c==5:
            ans+='D'
        elif c==4:
            ans+='CD'
        elif c==9:
            ans+='CM'
        elif c>5:
            ans+='D'
            for dd in range(c-5):
                ans+='C'
        else:
            for cc in range(c):
                ans+='C'
        
        
        if x==5:
            ans+='L'
        elif x==4:
            ans+='XL'
        elif x==9:
            ans+='XC'
        elif x>5:
            ans+='L'
            for xx in range(x-5):
                ans+='X'
        else:
            for ll in range(x):
                ans+='X'
        
        print(i)
        if i==5:
            ans+='V'
        elif i==4:
            ans+='IV'
        elif i==9:
            ans+='IX'
        elif i>5:
            ans+='V'
            for ii in range(i-5):
                ans+='I'
        else:
            for vv in range(i):
                ans+='I'
        
        return ans
        
