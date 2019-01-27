class Solution:
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        nums.sort()
        ans=0
        if len(nums)>1:
            for i in range(len(nums)):
                if i%2==0:
                    ans+=nums[i]
        else:
            return nums[0]
        return ans
