class Solution {

    boolean isOdd(int i) {
        if (i % 2 != 0) return true;
        return false;
    }

    int atmost(int[] nums, int goals) {
        if (goals < 0) return 0;
        int left = 0;
        int count = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            if (isOdd(nums[right])) {
                count++;
            }
            while (count > goals) {
                if (isOdd(nums[left])) {
                    count--;
                }
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k - 1);
    }
}
