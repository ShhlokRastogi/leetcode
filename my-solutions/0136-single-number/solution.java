class Solution {
    public int singleNumber(int[] nums) {
        int c;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for(int n:set){
            c=0;
            for(int i=0;i<nums.length;i++){
                if(n==nums[i]){
                    c++;
                }
            }
            if(c==1){
              return n;
            }
        } 
        return 0;
    }
}
