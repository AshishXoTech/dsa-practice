class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> checked = new HashSet<>();
        for (int num : nums) {
            checked.add(num);
        }
        int ans = k;
        while (checked.contains(ans)) {
            ans += k;
        }
        return ans;
    }
}