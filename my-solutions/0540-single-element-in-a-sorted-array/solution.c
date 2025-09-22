int singleNonDuplicate(int* nums, int numsSize) {
    int c=0;
    if(numsSize==1){
        return nums[0];
    }
    for(int i=0;i<numsSize;i++){
            if(i==0 && nums[i]==nums[i+1]){
                c++;
            }
            else if(i==numsSize-1 && nums[i-1]==nums[i]){
                c++;
            }
else if(i > 0 && i < numsSize - 1 && (nums[i] == nums[i+1] || nums[i] == nums[i-1])){

                c++;
            }
        if(c==0){
            return nums[i];
        }
        c=0;
        }
        return -1;
}
