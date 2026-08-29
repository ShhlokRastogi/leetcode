class Solution {

    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums.length % k != 0) return false;

        HashMap<Integer, Integer> fmap = new HashMap<>();
        for (int i : nums) {
            fmap.put(i, fmap.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            // This number has already been completely used
            if (fmap.get(nums[i]) == 0) {
                continue;
            }
            // Create a group of k consecutive numbers
            for (int j = 0; j < k; j++) {

                int n = nums[i] + j;
                
                // check if they are consecutive
                if (fmap.getOrDefault(n, 0) == 0) {
                    return false;
                }

                fmap.put(n, fmap.get(n) - 1);
            }
        }

        return true;
    }
}
