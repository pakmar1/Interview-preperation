class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        xx = str(x)
        e = len(xx)-1
        n = int(len(xx)/2)
        for i in range(n):
            if xx[i] != xx[e]:
                return False
            if e>n:
                e-=1
        return True
