class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int total = 0;
        for (int stone : stones) {
            total += stone;
        }
        int best = total;
        for (int i = n - 1; i >= 2; i--) {
            total -= stones[i];
            best = Math.max(best, total - best);
        }
        return best;
    }
}