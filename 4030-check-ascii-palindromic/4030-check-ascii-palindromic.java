class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder res = new StringBuilder();
        for(char ch : s.toCharArray()) {
            String binStr = Integer.toBinaryString(ch);
            String padded = String.format("%8s", binStr).replace(' ', '0');
            res.append(padded).append(" ");
        }
        String res2 = res.toString().trim();
        int i = 0;
        int j = res2.length() - 1;
        while(i < j) {
            if(res2.charAt(i) == res2.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}