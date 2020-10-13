class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        int[] markA = new int[26], markB = new int[26];
        int diff = 0;
        for (int i = 0; i < A.length(); i++) {
            char charA = A.charAt(i), charB = B.charAt(i);
            markA[charA - 'a']++;
            markB[charB - 'a']++;
            if (charA != charB) diff++;
        }
        boolean valid = false;
        for (int i = 0; i < 26; i++) {
            if (markA[i] != markB[i]) return false;
            if (markA[i] > 1) valid = true;
        }
        return A.equals(B) ? valid : diff == 2;
    }
}
