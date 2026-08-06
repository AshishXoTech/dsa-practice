class Solution {
    public int smallestNumber(int n, int t) {
        for(int i = n ;; i++){
            int prod = 1;
            for(int j = i; j > 0; j /=10){
                prod *= (j % 10);
            }
            if(prod % t == 0){
                return i;
            }
        }
    }
}