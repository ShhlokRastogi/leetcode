class Solution {
    public void moveZeroes(int[] nums) {
        int z = 0;
        int l = nums.length;
        if (nums.length != 1) {
            for (int i = 0; i < l; i++) {
                if (nums[i] == 0) {
                    for (int j = i; j < l - 1; j++) {
                        nums[j] = nums[j + 1];
                    }
                    l--;
                    i--;
                    z++;
                }
            }
            for (int i = nums.length - z; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
}

