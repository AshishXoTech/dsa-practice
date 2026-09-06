class Solution {
    public int sumDecoded(long[] nums) {
        long MOD = 1000000007L;
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            long width = nums[i] % 10;
            long d = nums[i] / 10;

            int digits = 0;
            long temp = d;

            while (temp > 0) {
                digits++;
                temp /= 10;
            }

            int yDigits = digits - (int) width;

            long divisor = 1;

            for (int k = 0; k < yDigits; k++) {
                divisor *= 10;
            }

            long x = d / divisor;
            long y = d % divisor;

            long value = power(x, y, MOD);

            ans = (ans + value) % MOD;
        }

        return (int) ans;
    }

    private long power(long x, long y, long MOD) {
        long result = 1;

        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % MOD;
            }

            x = (x * x) % MOD;
            y /= 2;
        }

        return result;
    }
}