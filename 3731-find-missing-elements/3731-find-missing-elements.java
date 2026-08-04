class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> al = new ArrayList<>();
        Arrays.sort(nums);
        int curr = nums[0];
        for(int i = 0 ; i < nums.length ; curr++, i++){
            if(curr < nums[i]){
                al.add(curr);
                i--;
            }
        }
        return al;
    }
}