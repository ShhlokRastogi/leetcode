int searchInsert(int* nums, int numsSize, int target) {
    int f = 0;                 
    int l = numsSize - 1;   
    
    while (f <= l) {  
        int m = (f + l) / 2;  
        
        if (nums[m] == target) {
            return m;   // found
        }
        else if (nums[m] < target) {
            f = m + 1;         
        }
        else {
            l = m - 1;        
        }
    }
    return f;  // correct insert position
}

