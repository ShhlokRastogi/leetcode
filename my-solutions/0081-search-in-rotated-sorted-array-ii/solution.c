#include <stdbool.h>

bool search(int* nums, int numsSize, int target) {
    if (numsSize == 0) return false;
    int i = 0;
    int found = 0;     
    int k = 0;
        bool allSame = true;
    for (int i = 1; i < numsSize; i++) {
        if (nums[i] != nums[0]) {
            allSame = false;
            break;
        }
    }
    if (allSame) {
        return nums[0] == target;
    }
    if (numsSize == 1) {
        return nums[0] == target;
    }
    if (nums[0] < nums[numsSize - 1]) {
        k = 1;
    }
    if (k == 1) {
        int low = 0, high = numsSize - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    } else {
        bool pivot_found = false;
        for (i = 0; i < numsSize - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                found = i + 1;
                pivot_found = true;
                break;
            }
        }
        if (!pivot_found) {
            found = 0;
        }
        int c = 0;
        for (int j = found; c < numsSize; j = (j + 1) % numsSize) {
            if (nums[j] == target) return true;
            c++;
        }
        return false;
    }
}
