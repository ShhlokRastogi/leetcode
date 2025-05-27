class Solution(object):
    def twoSum(self, nums, target):
        for i in range(len(nums)):
             for k in range(len(nums)):
                if i==k:
                    continue 
                if nums[i]+nums[k] == target:
                    t=[i,k]
                    return(t)
                    break
        return ()
        
