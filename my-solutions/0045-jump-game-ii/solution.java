class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int jumps = 0;
        int i = 0;
        int currEnd = 0;

        while (currEnd < nums.length - 1) {
            jumps++;

            int farthest = currEnd;

            // scan all positions reachable with current jump
            while (i <= currEnd) {
                farthest = Math.max(farthest, i + nums[i]);
                i++;
            }

            currEnd = farthest; // extend to next range
        }

        return jumps;
    }
}

