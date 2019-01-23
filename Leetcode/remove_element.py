class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        count = 0
        if len(nums)<1:
            return 0
        i = 0
        while i<len(nums):
            if nums[i]==val:
                del nums[i]
                i=0
                continue
            i+=1
        
        return len(nums)
