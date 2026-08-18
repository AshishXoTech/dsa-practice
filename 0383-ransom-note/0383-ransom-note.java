class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
      HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        }

        for(int i=0;i<ransomNote.length();i++){
            Character ch=ransomNote.charAt(i);
            Integer cnt = map.get(ch);
            if (cnt == null|| cnt ==0) {
                return false;
            }
            map.put(ch, cnt - 1);
        }
        return true;
   
    }
}