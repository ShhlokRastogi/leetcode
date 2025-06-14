class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n-1 ; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        if(nums[0]>0){
        return nums[0]-1;
        }
        else{
            return nums[n-1]+1;
        }
        }
    }
