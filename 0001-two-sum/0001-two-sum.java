class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int a = nums[i];
            int required = target - a;
            if(map.containsKey(required)){
                return new int[]{map.get(required), i};
            }
            map.put(a, i);
        }
        return new int[]{-1, -1};
    }
}