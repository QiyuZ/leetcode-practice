class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) return true;
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }
}
