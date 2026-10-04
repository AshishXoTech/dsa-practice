class Solution {
    public int minRotations(String s) {
        int rotations = 0;
        int current = 0;
        for (char ch : s.toCharArray()) {
            int next = ch - '0';
            int diff = Math.abs(current - next);
            rotations += Math.min(diff, 10 - diff);
            current = next;
        }
        return rotations;
    }
}