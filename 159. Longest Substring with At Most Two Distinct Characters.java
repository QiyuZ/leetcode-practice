//if replace  2 with k than it becomes 340
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] mark = new int[256];
        int res = 0, count = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (mark[s.charAt(i)]++ == 0) count++;
            if (count == 3) {
                while (--mark[s.charAt(start)] > 0) start++;
                start++;
                count--;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
