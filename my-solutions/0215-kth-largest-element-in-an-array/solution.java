class Solution {
    public int qs(int[] nums, int low, int high, int k) {
        if (low <= high) {
            int pivotIndex = partition(nums, low, high);

            if (pivotIndex == k) {
                return nums[pivotIndex];
            } else if (pivotIndex < k) {
                return qs(nums, pivotIndex + 1, high, k);  
            } else {
                return qs(nums, low, pivotIndex - 1, k);  
            }
        }
        return -1;
    }

    public int partition(int[] nums, int low, int high) {
        int i = low - 1;
        int pivot = nums[high];
        for (int j = low; j < high; j++) {
            if (nums[j] > pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int swap = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = swap;

        return i + 1;
    }

    public int findKthLargest(int[] nums, int k) {
        int targetIndex = k - 1;
        return qs(nums, 0, nums.length - 1, targetIndex);
    }
}

