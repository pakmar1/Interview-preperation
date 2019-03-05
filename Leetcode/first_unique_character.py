class Solution:
    def firstUniqChar(self, s: str) -> int:
        c = collections.Counter(s)
        for i,v in enumerate(s):
            if c[v] == 1:
                return i
        return -1
