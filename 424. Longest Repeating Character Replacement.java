class Solution {
    public int characterReplacement(String s, int k) {
        int[] record = new int[26];
        int res = 0, start = 0, end = 0, maxLen = 0;
        while (end < s.length()) {
            maxLen = Math.max(maxLen, ++record[s.charAt(end) - 'A']);
            if (end - start + 1 - maxLen > k) { //这里很tricky,但是要记住res其实是maxLen+k, 所以即使变小了也不用管它，移动窗口就行了
                record[s.charAt(start++) - 'A']--;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}
