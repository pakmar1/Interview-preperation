class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        return " ".join([elem for elem in s.strip().split(" ") if elem!=""][::-1])
