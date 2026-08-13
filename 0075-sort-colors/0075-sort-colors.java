class Solution {
    public void sortColors(int[] nums) {
        int lp = 0;
        int mp = 0;
        int rp = nums.length-1;
        while(mp <= rp){
            if(nums[mp] == 0){
                int temp = nums[lp];
                nums[lp] = nums[mp];
                nums[mp] = temp;
                lp++;
                mp++;
            }
            else if(nums[mp] == 1){
                mp++;
            }
            else{
                int temp = nums[mp];
                nums[mp] = nums[rp];
                nums[rp] = temp;
                rp--;
            }
        }
    }
}