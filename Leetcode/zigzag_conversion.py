class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1: return s
        count, flag = 0, 1
        res = [''] * numRows
        for i, char in enumerate(s):
            res[count] += char
            if (flag == 1 and count == numRows - 1) or (flag == -1 and count == 0):
                flag = -flag
            count += flag
        return ''.join(res)
