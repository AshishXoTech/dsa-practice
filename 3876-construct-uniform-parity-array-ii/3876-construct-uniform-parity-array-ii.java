class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
     
        int allEven=0,allOdd=0,n=nums1.length;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 != 0) {
                minOdd = Math.min(minOdd, nums1[i]);
                allOdd++;

            }else{
                
                allEven++;
            }

        }if(allEven==n||allOdd==n)return true;

        boolean isValid=true;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]<minOdd){
                isValid=false;
            }
        }
        return isValid;
    }
}