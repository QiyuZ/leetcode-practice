class Solution {
    public int longestDecomposition(String text) {
        String l = "", r = "";
        int res = 0, n = text.length();
        for (int i = 0; i < n / 2; i++) {
            l += text.charAt(i);
            r = text.charAt(n - i - 1) + r; //后面的的是要加到前面
            if (l.equals(r)) {
                res += 2;
                l = "";
                r = "";
            }
        }
        if (n % 2 == 0 && l == "" && r == "") return res; //说明没有中间的
        return res + 1;
    }
}
