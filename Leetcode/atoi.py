class Solution:
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        def f(x):
            return {
                '1': 1,
                '2': 2,
                '3':3,
                '4':4,
                '5':5,
                '6':6,
                '7':7,
                '8':8,
                '9':9,
                '0':0 
            }[x]
        con=0#whether we are converting str
        sch=['+','-']
        sign=1
        valch=['0','1','2','3','4','5','6','7','8','9']
        val=[]
        ni=0# number of number in the result
        for ch in str:
            # find starting point
            if (not con):
                if (ch in sch): 
                    con=1
                    sign={'+':1,'-':-1}[ch]
                elif (ch in valch):
                    con=1
                    ni+=1
                    val.append(f(ch))
                elif ch !=' ':
                    return 0
            elif (ch in valch): #that means we are in the processing of converting str
                val.append(f(ch))
                ni+=1
            else: # we find the end 
                break
        if ni>0:
            result=0
            for i,num in enumerate(val):
                result+=num*(10**(ni-i-1))
            result = result*sign
            if (result<(-2)**31):
                result= (-2)**31
            elif  result>2**31-1 :
                result=  2**31-1
            
            return result
        else :
            return 0
