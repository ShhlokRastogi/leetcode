class Solution {
    int atMost(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
        map.put(nums[right],
                map.getOrDefault(nums[right], 0) + 1);
        while (map.size() > k) {
            int temp = nums[left];
            map.put(temp, map.get(temp) - 1);
            if (map.get(temp) == 0) {
                map.remove(temp);
            }
            left++;
        }
        count += right - left + 1;
    }
    return count;
}
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
}
