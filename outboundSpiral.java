//給一個String 用outbound spiral方式輸出 (ex. abcde -> cdbae)

class Solution {
    public String outbounSpiral(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        int n = s.length(), mid = n / 2;
        if (n % 2 == 0) sb.append(s.charAt(mid));
        for (int i = mid; i > 0; i--) {
            sb.append(s.charAt(n - i));
            sb.append(s.charAt(i - 1));
        }
        return sb.toString();
    }
}
