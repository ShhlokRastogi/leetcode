class Solution {
    public int majorityElement(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        int m = 0, majorityElement = nums[0];
        for(int n:nums){
            numset.add(n);
        }
        for (int n : numset) {
            int c = 0;
            for (int n2 : nums) {
                if (n2 == n) {
                    c++;
                }
            }
            if (c > m) {
                m = c;
                majorityElement = n;
            }
        }
        return majorityElement;
    }
}
