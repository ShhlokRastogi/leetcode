class Solution {
    int[] sort(int n[], int len) {
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {   
                if (n[i] > n[j]) {                
                    int temp = n[i];
                    n[i] = n[j];
                    n[j] = temp;
                }
            }
        }
        return n;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; 
        int j = 0;     
        while (i >= 0 && j < n) {
            if (nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
            }
            i--;
            j++;
        }
        nums1=sort(nums1,m);
        nums2=sort(nums2,n);
        for (int k = 0; k < n; k++) {
            nums1[m + k] = nums2[k];
        }
    }
}
