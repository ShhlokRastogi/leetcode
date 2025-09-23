#include <stdio.h>
#include <stdbool.h>

int search(int* nums, int numsSize, int target) {
    int i = 0;
    int found = 0;
    int k = 0;
    if (numsSize == 1) {
        return nums[0] == target ? 0 : -1;
    }
    if (nums[0] < nums[numsSize - 1]) {
        k = 1;
    }
    if (k == 1) {
        int low = 0, high = numsSize - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    else {
        for (i = 0; i < numsSize - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                found = i + 1;
                break;
            }
        }
    }
    int c = 0;
    for (int j = found; c < numsSize; j = (j + 1) % numsSize) {
        if (nums[j] == target) return j;
        c++;
    }
    return -1;
}

