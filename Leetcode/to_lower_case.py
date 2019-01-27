class Solution:
    def toLowerCase(self, str):
        """
        :type str: str
        :rtype: str
        """
        ans =""
        for char in str:
            if ord(char) in range(65,91):
                ans +=chr(ord(char)+32)
            else:
                ans+=char
        
        return ans
