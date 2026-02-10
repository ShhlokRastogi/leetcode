class Solution {
    public long hourCalc(int[] piles, long k) {
        long totalHours = 0;
        for (int p : piles) {
            totalHours += (long) Math.ceil((double) p / (double) k);
        }
        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        long low = 1;
        long high = 0;
        for (int p : piles) {
            high = Math.max(high, p);
        }
        long ans = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long needed = hourCalc(piles, mid);

            if (needed <= h) {
                ans = mid;       
                high = mid - 1;
            } else {
                low = mid + 1;   
            }
        }
        return (int) ans;
    }
}

