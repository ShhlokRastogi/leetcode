class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] nge = new int[nums2.length];
    Stack < Integer > st = new Stack < > ();

    for (int i = nums2.length - 1; i >= 0; i--) {

      if (st.isEmpty()) {
        nge[i] = -1;
        st.push(nums2[i]);
        continue;
      }

      while (!st.isEmpty()) {
        if (st.isEmpty()) {
          nge[i] = -1;
          break;
        } else if (st.peek() > nums2[i]) {
          nge[i] = st.peek();
          st.push(nums2[i]);
          break;
        } else {
          st.pop();
        }
      }

      if (st.isEmpty()) {
        nge[i] = -1;
        st.push(nums2[i]);
      }
    }
    int[] nge1 = new int[nums1.length];
    HashMap < Integer, Integer > map = new HashMap < > ();

    for (int i = 0; i < nums2.length; i++) {
      map.put(nums2[i], nge[i]);
    }

    for (int i = 0; i < nums1.length; i++) {
      nge1[i] = map.get(nums1[i]);
    }

    return nge1;
  }
}
