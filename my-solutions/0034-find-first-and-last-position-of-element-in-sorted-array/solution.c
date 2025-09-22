#include <stdio.h>
#include <stdlib.h>

int* searchRange(int* nums, int numsSize, int target, int* returnSize) {
    *returnSize = 2;
    int* result = (int*)malloc(2 * sizeof(int));
    int low = 0, high = numsSize - 1;
    int mid;
    int k=0;
    int i=0;
    while (low <= high) { 
        mid = (low + high) / 2;
        if (nums[mid] == target) {  
            k=1;
            i=mid;
            break;  
        } else if (nums[mid] < target) {
            low = mid + 1; 
        } else {
            high = mid - 1; 
        }
    }
    if (k==0) {   
        result[0] = -1;
        result[1] = -1;
        return result;
    }
    int j=i;
    result[0]=i;
    result[1]=i;
    i++;
    while (i < numsSize && nums[i] == target) { 
        result[1] = i;
        i++;
    }
while (j > 0 && nums[j-1] == target) { 
    j--;
}
result[0] = j;

        return result; 
}
