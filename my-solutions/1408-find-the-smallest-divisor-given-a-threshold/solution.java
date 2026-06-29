class Solution {
    public int divideNsum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int low = 1;
        int high = max;
        int mid;
        int sum;
        int smallestdiv = max;
        while (low <= high) {
            mid = (low + high) / 2;
            sum = divideNsum(nums, mid);
            if (sum > threshold) {
                low = mid + 1;
            } else {
                smallestdiv = mid;
                high = mid - 1;
            }
        }
        return smallestdiv;
    }
}
