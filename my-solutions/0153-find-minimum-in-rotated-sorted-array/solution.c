int findMin(int* nums, int numsSize) {
    int i=0;
    if((nums[0]<nums[numsSize-1])||(numsSize==1)){
        return nums[0];
    }
    while(1){
        if(nums[i]>nums[(i+1)%numsSize]){
            return nums[(i+1)%numsSize];
        }
        i=(i+1)%numsSize;
    }
}
