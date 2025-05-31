class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        num3=nums1+nums2
        num3.sort()
        if len(num3)%2==0:
            n=len(num3)//2
            number1=num3[n]
            number2=num3[n-1]
            median=(number1+number2)/2
        else:
            n=len(num3)//2
            median=num3[n]
        return(median)         
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        
