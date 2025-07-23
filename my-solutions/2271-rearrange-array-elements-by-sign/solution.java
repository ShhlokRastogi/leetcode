class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] arr = new int[nums.length];
        int p = 0;
        int n = 1;

        for (int i : nums) {
            if (i > 0) {
                arr[p] = i;
                p += 2;
            } else {
                arr[n] = i;
                n += 2;
            }
        }

        return arr;
    }
}

