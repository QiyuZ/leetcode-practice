class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] mark = new boolean[256];
        int res = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            while (mark[s.charAt(i)]) mark[s.charAt(start++)] = false;
            mark[s.charAt(i)] = true;
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
