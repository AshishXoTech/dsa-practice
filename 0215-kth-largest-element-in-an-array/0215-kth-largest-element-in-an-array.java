class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> a=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            a.add(nums[i]);
            if(a.size()>k){
                a.poll();
            }
        }
        return a.peek();
    }
}