class Solution {
    public int sumOfMultiples(int n) {
        return (int) (
            sumDivisibleBy(n, 3)
            + sumDivisibleBy(n, 5)
            + sumDivisibleBy(n, 7)
            - sumDivisibleBy(n, 15)
            - sumDivisibleBy(n, 21)
            - sumDivisibleBy(n, 35)
            + sumDivisibleBy(n, 105)
        );
    }
    private long sumDivisibleBy(int n, int d) {
        long k = n / d;
        return (long) d * k * (k + 1) / 2;
    }
}