class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums3 = nums1+nums2
        nums3.sort()
        
        l =int(len(nums3)/2)
        ans = -1
        
        print(nums3,l)
        
        
        if len(nums3)%2==0:
            ans = (nums3[l]+nums3[l-1])/2
        else:
            ans = nums3[l]
        
        return ans
