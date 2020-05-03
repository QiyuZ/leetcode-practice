class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.isEmpty()) return true;
        int[] map = new int[128];
        for (char c : ransomNote.toCharArray()) map[c - 'A']++;
        for (char c : magazine.toCharArray()) map[c - 'A']--;
        for (int num : map) {
            if (num > 0) return false;
        }
        return true;
    }
}
