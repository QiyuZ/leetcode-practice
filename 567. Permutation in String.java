class Solution { //O(n)
    public boolean checkInclusion(String s1, String s2) {
        int[] mark = new int[26];
        for (char s : s1.toCharArray()) mark[s - 'a']++;
        int left = 0, right = 0, count = 0;
        while (right < s2.length()) {
            if (mark[s2.charAt(right++) - 'a']-- > 0) count++;
            if (count == s1.length()) return true;
            if (right - left == s1.length()) {
                if (mark[s2.charAt(left++) - 'a']++ >= 0) count--;
            }
        }
        return false;
    }
}

class Solution {//O(26n)
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        if (s1.length() == 0) return true;
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--;
            if (i >= s1.length()) count[s2.charAt(i - s1.length()) - 'a']++;
            if (allZero(count)) return true;
        }
        return false;
    }
    public boolean allZero(int[] count) {
        for (int num : count) {
            if (num != 0) return false;
        }
        return true;
    }
}
