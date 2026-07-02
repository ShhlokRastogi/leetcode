class Solution {
    public long subArrayRanges(int[] nums) {
        long smallest = sumSubarrayMins(nums);
        long largest = sumSubarrayMaxs(nums);
        return largest - smallest;
    }

    public long sumSubarrayMaxs(int[] arr) {
        int[] nge = nge(arr);
        int[] pge = pge(arr);

        long total = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;

            total += (long) arr[i] * left * right;
        }

        return total;
    }

    public long sumSubarrayMins(int[] arr) {
        int[] nse = nse(arr);
        int[] pse = pse(arr);

        long total = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            total += (long) arr[i] * left * right;
        }

        return total;
    }

    public int[] nse(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

    public int[] pse(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pse;
    }

    public int[] nge(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nge;
    }

    public int[] pge(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pge;
    }
}
