class Solution {
    public boolean checkDivisibility(int n) {
        int value = n;
        int sum = 0;
        int product = 1;
        while(n != 0){
            int x = n % 10;
            sum += x;
            product *= x;
            n /= 10;
        }
        int ans = sum + product;
        return value % ans == 0;
    }
}