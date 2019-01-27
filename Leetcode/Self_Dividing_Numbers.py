class Solution:
    def selfDividingNumbers(self, left, right):

        ans = [] 
        for i in range(left,right+1):
            x1=x2=x3=x4=x5=-1
            if i>9999:
                x5 = int(i/10000)
            if i>999:
                x4 = int((i%10000)/1000)
            if i>99:
                x3 = int((i%1000)/100)
            if i>9:
                x2 = int((i%100)/10)
            x1 = int((i%100)%10)
            
            if x1==0 or x2==0 or x3==0 or x4==0 or x5 == 1:
                continue
            else:
                if i%x1==0 and i%x2==0 and i%x3==0 and i%x4==0:
                    ans.append(i)
        
        
        return ans
        
            
