class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0,zero=0,maxc=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) zero++; //adding number
            
            while(zero>k){         // checking validity of zeros
                if(nums[left]==0){
                    zero--;
                }
                left++;
            }
            int win_len=i-left+1;
            maxc=Math.max(maxc,win_len);
        }
        return maxc;
    }
}
