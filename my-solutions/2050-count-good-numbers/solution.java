class Solution {
    static final long MOD = 1_000_000_007;

    long power(long x, long n) {
        if (n == 0)
            return 1;

        if (n == 1)
            return x % MOD;

        x = x % MOD;

        if (n % 2 == 0) {
            return power((x * x) % MOD, n / 2);
        } else {
            return (x * power((x * x) % MOD, n / 2)) % MOD;
        }
    }

    public int countGoodNumbers(long n) {
        long evenPos = (n + 1) / 2;
        long oddPos = n / 2;

        long ans = (power(5, evenPos) * power(4, oddPos)) % MOD;

        return (int) ans;
    }
}
