class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int cand1 = -1, cand2 = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (cand2 != -1) return false;
                if (cand1 == -1) cand1 = i;
                else cand2 = i;
            }
        }
        return cand2 != -1 && s1.charAt(cand1) == s2.charAt(cand2) && s1.charAt(cand2) == s2.charAt(cand1);
    }
}
