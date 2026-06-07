class Solution {
  public int[] nextGreaterElements(int[] nums) {

    int[] nge = new int[nums.length];
    Stack < Integer > st = new Stack < > ();
    int k;
    for (int i = nums.length * 2 - 1; i >= 0; i--) {
      k = i % nums.length;
      if (st.isEmpty()) {
        nge[k] = -1;
        st.push(nums[k]);
        continue;
      }
      while (!st.isEmpty()) {
        if (st.isEmpty()) {
          nge[k] = -1;
          st.push(nums[k]);
          break;
        } else if (st.peek() > nums[k]) {
          nge[k] = st.peek();
          st.push(nums[k]);
          break;
        } else {
          st.pop();
        }
      }
      if (st.isEmpty()) {
        nge[k] = -1;
        st.push(nums[k]);
      }
    }

    return nge;
  }
}
