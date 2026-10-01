class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (char key : freq.keySet()) {
            pq.offer(new int[]{freq.get(key), key});
        }

        Map<Character, Integer> nextAvailable = new HashMap<>();

        int time = 1;

        while (!pq.isEmpty()) {
            List<int[]> temp = new ArrayList<>();

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                char task = (char) curr[1];

                if (nextAvailable.getOrDefault(task, 1) <= time) {
                    curr[0]--;

                    if (curr[0] > 0) {
                        temp.add(curr);
                    }

                    nextAvailable.put(task, time + n + 1);
                    break;
                } else {
                    temp.add(curr);
                }
            }

            pq.addAll(temp);
            time++;
        }

        return time - 1;
    }
}