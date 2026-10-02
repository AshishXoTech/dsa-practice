class Solution {
    public int[] rearrangeArray(int[] nums) {
        Map<Integer, Integer> freq = new TreeMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[nums.length];
        int index = 0;
        while (!freq.isEmpty()) {
            Iterator<Map.Entry<Integer, Integer>> it = freq.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                ans[index++] = entry.getKey();
                int count = entry.getValue();
                if (count == 1) {
                    it.remove();
                } else {
                    entry.setValue(count - 1);
                }
            }
        }
        return ans;
    }
}