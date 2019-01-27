class Solution:
    def hammingDistance(self, x, y):
        return bin(x^y).count('1')
