class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        count = 0
        max_=0
        for i in range(len(nums)):
            if nums[i]!=1:
                count=0
            else:
                count+=1
            
            if count>max_:
                max_=count
        return max_
