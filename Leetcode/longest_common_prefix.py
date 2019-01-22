class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        ans = ""
        if len(strs)<1:
            return ans
        elif len(strs)==1:
            return strs[0]
        
        for i in range(len(strs[0])):
            c = strs[0][i]
            for j in range(len(strs)):
                if i == len(strs[j]) or strs[j][i] != c:
                    return strs[0][:i]
        
        return strs[0]
