class Solution {
    private static final char[][] PAIRS  = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    public int strobogrammaticInRange(String low, String high) {
        int res = 0;
        for (int len = low.length(); len <= high.length(); len++) {//按照长度来算，由小到大
            res += dfs(low, high, new char[len], 0, len - 1);
        }
        return res;
    }
    private int dfs(String low, String high, char[] cur, int left, int right) {
        if (left > right) {
            String s = new String(cur);
            if ((cur.length == low.length() && s.compareTo(low) < 0) || (cur.length == high.length() && s.compareTo(high) > 0)) {
                return 0;
            } 
            return 1;

        }
        int res = 0;
        for (char[] p : PAIRS) {
            cur[left] = p[0];
            cur[right] = p[1];
            if (left == right && p[0] != p[1]) continue; //中间的数字必须是0,1,8这样才对称
            if (cur.length > 1 && cur[0] == '0') continue; //0X 这样的数字不成立
            res += dfs(low, high, cur, left + 1, right - 1);
        }
        return res;
    }
}
