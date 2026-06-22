class Solution {

    public int sumSubarrayMins(int[] arr) {
        int[] nse = nse(arr);
        int[] pse = pse(arr);

        long total_sum = 0;
        int MOD = 1_000_000_007;

        for (int i = 0; i < arr.length; i++) {
            long lchoice = i - pse[i];
            long rchoice = nse[i] - i;

            total_sum = (total_sum + (arr[i] * lchoice * rchoice) % MOD) % MOD;
        }

        return (int) total_sum;
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
}
