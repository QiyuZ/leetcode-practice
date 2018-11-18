class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] as = new char[26], at = new char[26];
        for (int i = 0; i < s.length(); i++) {
            as[s.charAt(i) - 'a']++;
            at[t.charAt(i) - 'a']++;
        }
        String ss = new String(as), st= new String(at);
        if (ss.equals(st)) return true;
        return false;
    }
}
