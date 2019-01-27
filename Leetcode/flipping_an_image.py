class Solution:
    def flipAndInvertImage(self, A):
        h = len(A[0])
        v = len(A)

        for i in range(len(A)):
            for j in range(int(len(A[0])/2)):
                tmp = A[i][j]
                A[i][j] = A[i][h-j-1]
                A[i][h-j-1] = tmp
        for i in range(len(A)):
            for j in range(len(A[0])):
                if A[i][j]==0:
                    A[i][j]=1
                elif A[i][j]==1:
                    A[i][j] =0
        return A
