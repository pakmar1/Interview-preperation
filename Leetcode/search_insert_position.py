class Solution:
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        for i in range(len(nums)):
            #print(i)
            if target == nums[i]:
                return i
            elif target<nums[i]:
                if i == 0:
                    return 0
                return i
        return i+1
