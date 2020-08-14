class Solution {
    public int longestPalindrome(String s) {
        int[] mark = new int[58]; //a-z, A-Z
        for (char c : s.toCharArray()) mark[c - 'A']++;
        int res = 0;
        boolean mid = false; //中间有没有
        for (int m : mark) {
            if (m % 2 == 0) res += m;
            else {
                res += m - 1;
                mid = true;
            }
        }
        return mid ? res + 1 : res;
    }
}
