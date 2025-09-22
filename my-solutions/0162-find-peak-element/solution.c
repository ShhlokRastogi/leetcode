int findPeakElement(int* nums, int numsSize) {
    int peak = 0;

    if (numsSize == 1) {
        return 0;  // Only one element, it's the peak
    }

    for (int i = 0; i < numsSize; i++) {
        if (i == 0 && nums[i] > nums[i+1]) {
            peak = i;
        }
        else if (i == numsSize - 1 && nums[i] > nums[i-1]) {
            peak = i;
        }
        else if (i > 0 && i < numsSize - 1 && (nums[i] > nums[i+1] && nums[i] > nums[i-1])) {
            peak = i;
        }
    }

    return peak;
}
