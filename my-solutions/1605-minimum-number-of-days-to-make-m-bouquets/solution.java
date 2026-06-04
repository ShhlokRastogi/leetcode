class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        if ((long)m * k > bloomDay.length)
            return -1;

        int min = bloomDay[0];
        int max = bloomDay[0];

        for (int x : bloomDay) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        while (min <= max) {

            int mid = min + (max - min) / 2;

            if (possible(bloomDay, m, k, mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }
    private boolean possible(int[] bloomDay, int m, int k, int day) {
        int count = 0;
        int bouquets = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                count++;
            } else {
                bouquets += count / k;
                count = 0;
            }
        }
        bouquets += count / k;
        return bouquets >= m;
    }
}
