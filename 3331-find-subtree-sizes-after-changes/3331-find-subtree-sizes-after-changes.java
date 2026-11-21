class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }
        int[] newParent = parent.clone();
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int[] oldLast = new int[n];
        int[] stack = new int[2 * n];
        int top = 0;
        stack[top++] = 0;
        while (top > 0) {
            int event = stack[--top];
            int node = event / 2;
            int c = s.charAt(node) - 'a';
            if (event % 2 == 0) {
                oldLast[node] = last[c];
                if (node != 0) {
                    if (last[c] != -1) {
                        newParent[node] = last[c];
                    }
                }
                last[c] = node;
                stack[top++] = node * 2 + 1;
                for (int child : children[node]) {
                    stack[top++] = child * 2;
                }
            } else {
                last[c] = oldLast[node];
            }
        }
        List<Integer>[] newChildren = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            newChildren[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            newChildren[newParent[i]].add(i);
        }
        int[] order = new int[n];
        top = 0;
        int size = 0;
        stack[top++] = 0;
        while (top > 0) {
            int node = stack[--top];
            order[size++] = node;
            for (int child : newChildren[node]) {
                stack[top++] = child;
            }
        }
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        for (int i = size - 1; i > 0; i--) {
            int node = order[i];
            answer[newParent[node]] += answer[node];
        }
        return answer;
    }
}