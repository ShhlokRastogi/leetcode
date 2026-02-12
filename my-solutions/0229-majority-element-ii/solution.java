class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int c1 = 0, c2 = 0;
        int count1 = 0, count2 = 0;

        // First pass
        for (int i = 0; i < n; i++) {

            if (c1 == nums[i]) {
                count1++;
            }
            else if (c2 == nums[i]) {
                count2++;
            }
            else if (count1 == 0) {
                c1 = nums[i];
                count1++;
            }
            else if (count2 == 0) {
                c2 = nums[i];
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        // Reset counts
        count1 = 0;
        count2 = 0;

        // Second pass to verify
        for (int i = 0; i < n; i++) {

            if (c1 == nums[i] && c2 != nums[i]) {
                count1++;
            }
            else if (c2 == nums[i]) {
                count2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if (count1 > n / 3) {
            ans.add(c1);
        }

        if (count2 > n / 3) {
            ans.add(c2);
        }

        return ans;
        
    }
}
