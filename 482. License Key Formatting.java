class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder(S);
        int len = S.length();
        for (int i = K; i < len; i += K) sb.insert(len - i, "-");
        //因为第一个可以少，所以从后往前加，第一组就无所谓了；insert实在该位置插入，原先的往后移动
        return sb.toString();
    }
}
