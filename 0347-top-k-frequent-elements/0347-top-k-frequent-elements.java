class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int key : map.keySet()) {
            int freq = map.get(key);
            pq.offer(new int[] { freq, key });

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[1];
        }

        return result; 
    }
}