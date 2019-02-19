class Solution:
    def moveZeroes(self, nums: 'List[int]') -> 'None':
        """
        Do not return anything, modify nums in-place instead.
        """
        i = 0
        j = 1
        
        while i<j and j<len(nums):
            if nums[i] == 0:
                if nums[j] == 0:
                    j +=1
                    continue
                else:
                    temp = nums[j]
                    nums[i]+=temp
                    nums[j]-=temp
            j+=1
            i+=1
        print(nums)
