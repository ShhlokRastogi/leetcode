int maxProduct(int* nums, int numsSize) {
    int maxp = nums[0];
    int prod = 1;
    for (int i = 0; i < numsSize; i++) {
        prod *= nums[i];
        if (prod > maxp) {
            maxp = prod;
        }
        if (prod == 0) {
            prod = 1; 
        }
    }
    prod = 1; 
    for (int i = numsSize - 1; i >= 0; i--) {
        prod *= nums[i];
        if (prod > maxp) {
            maxp = prod;
        }
        if (prod == 0) {
            prod = 1;
        }
    }

    return maxp;
}

