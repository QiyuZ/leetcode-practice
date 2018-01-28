//constant time
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int p = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index == -1) continue;
            if (index == s.lastIndexOf(c)) p = Math.min(index, p);
        }
        return p == s.length() ? -1 : p;
    }
}

//O(n)
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                res = i;
                break;
            }
        }
        return res;
    }
}
