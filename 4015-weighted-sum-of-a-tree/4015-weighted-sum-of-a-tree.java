class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            children.get(parent[i]).add(i);
        }
        int[] depth = new int[n];
        depth[0] = 1;
        int height = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int child : children.get(node)) {
                depth[child] = depth[node] + 1;
                height = Math.max(height, depth[child]);
                queue.offer(child);
            }
        }
        int[] malviretho = nums;
        long answer = 0;
        for (int i = 0; i < n; i++) {
            long weight =
                (long) malviretho[i] *
                (height - depth[i] + 1);
            answer += weight;
        }
        return answer;
    }
}