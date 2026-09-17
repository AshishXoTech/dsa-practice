class Solution {
    public int countSpecialIntegers(int[] nums) {
         HashMap<Integer, List<Integer>> map = new HashMap<>();

  
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int count = 0;

        for (List<Integer> indices : map.values()) {

            if (indices.size() < 3) {
                continue;
            }

            int gap = indices.get(1) - indices.get(0);

            boolean special = true;

            for (int i = 2; i < indices.size(); i++) {
                if (indices.get(i) - indices.get(i - 1) != gap) {
                    special = false;
                    break;
                }
            }

            if (special) {
                count++;
            }
        }

        return count;
    }
}