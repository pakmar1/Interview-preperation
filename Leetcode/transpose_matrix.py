class Solution(object):
    def transpose(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        B = []
        
        for i in range(len(A[0])):
            ins = []
            for j in range(len(A)):
                ins.append(A[j][i])
            B.append(ins)
        return B
