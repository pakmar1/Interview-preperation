class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        
        if x < 0:
            y = str(abs(x))
            y = y[::-1]
            y = '-'+y 
        elif x ==0 or x > 2147483647 or x<-2147483648:
            return 0
        else:
            y = str(x)
            y = y[::-1]
            
        if(abs(int(y)) > 2147483647):
            return 0
        
        return int(y)
        
