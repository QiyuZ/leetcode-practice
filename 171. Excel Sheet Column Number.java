class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0, count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += Math.pow(26, count++) * (s.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
