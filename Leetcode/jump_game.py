class Solution:
    def canJump(self, nums: 'List[int]') -> 'bool':
        ans = False
        arr = nums
        i = len(arr)-1
        while i>0:
            j = i-1
            while j>=0 and arr[j]<i-j:
                j-=1
            i=j
        if i == 0:
            ans = True
        return ans
